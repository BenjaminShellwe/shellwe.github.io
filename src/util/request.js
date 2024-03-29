import axios from 'axios'
import { Message, MessageBox } from 'element-ui'
import store from '@/store'
import { getToken } from '@/util/auth'

const debug = process.env.NODE_ENV !== 'production'

// create an axios instance
const service = axios.create({
    baseURL: process.env.BASE_API, // api 的 base_url  use proxy table
    // timeout: 5000, // request timeout
    timeout: 15000 // 请求超时10秒
})

// request interceptor
service.interceptors.request.use(
    config => {
    // Do something before request is sent
        if (store.getters.token) {
            // 让每个请求携带token-- ['X-Token']为自定义key 请根据实际情况自行修改
            config.headers['X-Token'] = getToken()
        }
        if (debug) {
            console.log(config)
        }
        return config
    },
    error => {
    // Do something with request error
        console.log(error) // for debug
        Promise.reject(error)
    }
)

// response interceptor
service.interceptors.response.use(
    // response => response,
    /**
   * 下面的注释为通过在response里，自定义code来标示请求状态
   * 当code返回如下情况则说明权限有问题，登出并返回到登录页
   * 如想通过 xmlhttprequest 来状态码标识 逻辑可写在下面error中
   * 以下代码均为样例，请结合自生需求加以修改，若不需要，则可删除
   */
    response => {
        const res = response.data
        if (debug) {
            console.log(res)
        }
        if (res.code !== 200) {
            Message({
                message: res.message,
                type: 'error',
                duration: 5 * 1000
            })
            // 401:Token过期 或 未登录
            if (res.code === 401) {
                // 请自行在引入 MessageBox
                // import { Message, MessageBox } from 'element-ui'
                MessageBox.confirm('你已被登出，是否重新登录？', '提示', {
                    confirmButtonText: '重新登录',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    store.dispatch('FedLogOut').then(() => {
                        location.reload() // 为了重新实例化vue-router对象 避免bug
                    })
                })
            }
            return Promise.reject('error')
        } else {
            return response.data
        }
    },
    error => {
        console.log('err' + error) // for debug
        Message({
            message: error.message,
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    }
)

export default service
