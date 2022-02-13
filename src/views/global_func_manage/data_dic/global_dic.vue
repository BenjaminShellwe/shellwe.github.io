<template>
    <div>
        <page-header title="全局字典">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页</div>
                    <div>此页面为全局字典设置,在此页面控制本账号全局字典使用方式</div>
                    <span>是否开启数据字典 </span>
                    <el-switch
                        v-model="isShow"
                        active-text="开启"
                        inactive-text="关闭"
                        @click="changeShow"
                    />
                </div>
            </template>
        </page-header>
        <page-main v-show="isShow" id="collapsible">
            <span style="line-height: 2.2;">是否允许系统读取个人字典
                <el-switch
                    v-model="value1"
                    active-color="#13ce66"
                    inactive-color="#ff4949"
                    active-text="允许"
                    inactive-text="拒绝"
                />
            </span><br>
            <el-row>
                <el-col :span="5">
                    <div class="inLine">
                        <span slot="label">
                            <el-tooltip content="定义字典的名称 必填" placement="top">
                                <i class="el-icon-warning-outline" style="color: red;" />
                            </el-tooltip>
                        </span>
                        模板名称&nbsp;
                        <div class="inLine">
                            <el-input
                                v-model="pageQueryValue.typeName"
                                type="text"
                                size="small"
                                placeholder="请输入模板名称"
                                style="display: inline;"
                                maxlength="10"
                                show-word-limit
                            />
                        </div>
                    </div>
                </el-col>
                <el-col :span="6">
                    <div class="inLine">
                        <span slot="label">
                            <el-tooltip content="提供模板数据说明" placement="top">
                                <i class="el-icon-question" />
                            </el-tooltip>
                        </span>
                        模板说明&nbsp;
                        <div class="inLine">
                            <el-input
                                v-model="description"
                                type="text"
                                size="small"
                                placeholder="请输入模板说明"
                                style="display: inline;"
                                clearable
                            />
                        </div>
                    </div>
                </el-col>
                <el-col :span="5" style="margin-top: 15px;">
                    <div>
                        <span slot="label">
                            <el-tooltip content="定义字典的状态 必选 审核为工作人员使用" placement="top">
                                <i class="el-icon-warning-outline" style="color: red;" />
                            </el-tooltip>
                        </span>
                        模板状态&nbsp;
                        <el-select v-model="valueState" placeholder="请选择">
                            <el-option
                                v-for="item in options"
                                :key="item.valueState"
                                :label="item.label"
                                :value="item.valueState"
                                :disabled="item.disabled"
                                size="small"
                            />
                        </el-select>
                    </div>
                </el-col>
                <el-col :span="6" style="margin-top: 20px; margin-left: 10px;">
                    <el-button type="primary" icon="el-icon-search" size="mini" @click="handleButtonQuery">搜索</el-button>
                    <el-tooltip content="创建新字典数据" placement="top">
                        <el-button type="primary" icon="el-icon-document-add" size="mini" @click="dialogVisible = true">创建</el-button>
                    </el-tooltip>
                </el-col>
            </el-row>

            <br>
        </page-main>
        <page-main v-show="isShow">
            <template>
                <el-table :key="key" v-loading="false" :data="data" style="width: 100%;" border>
                    <el-table-column v-for="(value, index) in pageFormHead"
                                     :key="index"
                                     :label="value"
                                     :width="value.width"
                    >
                        <template slot-scope="scope">
                            {{ scope.row[value] }}
                        </template>
                    </el-table-column>
                    <el-table-column
                        fixed="right"
                        label="操作"
                        width="200"
                    >
                        <template>
                            <el-button-group>
                                <el-button type="primary" size="mini" @click="dialogVisible = true">编辑</el-button>
                                <el-button type="danger" size="mini" @click.native.prevent="dialogVisible = true">移除</el-button>
                            </el-button-group>
                        </template>
                    </el-table-column>
                </el-table>
            </template>
        </page-main>
        <el-dialog
            title="来自shellwe的警告"
            :visible.sync="dialogVisible"
            width="30%"
        >
            <span>开发中 此操作暂时拒绝</span>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
import axios from 'axios'
let fields = [
    {label: '日期', prop: 'date'},
    {label: '模板名称', prop: 'model_name'},
    {label: '模板说明', prop: 'model_explain'},
    {label: '模板状态', prop: 'model_state'}
]
export default {
    name: 'GlobalDic',
    components: {PageMain},
    data() {
        return {
            pageFormHead: [],
            dialogVisible: false,
            isShow: true,
            value1: true,
            description: '',
            pageList: [],
            pageQueryValue: {
                typeName: '',
                valueStatus: ''
            },
            valueState: '',
            options: [{
                valueState: 'options1',
                label: '有效'
            }, {
                valueState: 'options2',
                label: '无效'
            }, {
                valueState: 'options3',
                label: '审核',
                disabled: true
            }],
            key: 1, // table key
            formThead: fields, // 默认表头 Default header
            data: [{
                date: '2022-01-12-17:57',
                model_name: '示例1',
                model_explain: '展示示例',
                model_state: '有效'
            }]
        }
    },
    watch: {
        /**
         * 监控表格的数据data，自动设置表格宽度
         * @param https://www.cnblogs.com/huangxiaoxue/p/12034326.html
         */
        data(valArr) {
            const _this = this
            this.formThead = fields.map(function(value) {
                const arr = valArr.map(x => x[value.prop])  // 获取每一列的所有数据
                arr.push(value.label)  // 把每列的表头也加进去算
                value.width = _this.getMaxLength(arr) + 5 // 每列内容最大的宽度 + 表格的内间距(依据实际情况而定)
                return value
            })
        }
    },
    mounted() {
        this.getUser()
    },
    methods: {
        changeShow: function() {
            this.isShow = !this.isShow
            if (this.isShow == false) {
                this.value1 = false
            }
        },
        back() {
            history.go(-1)
        },
        handleClick(row) {
            console.log(row)
        },
        getMaxLength(arr) {
            return arr.reduce((acc, item) => {
                if (item) {
                    let calcLen = this.getTextWidth(item)
                    if (acc < calcLen) {
                        acc = calcLen
                    }
                }
                return acc
            }, 0)
        },
        getTextWidth(str) {
            let width = 0
            let html = document.createElement('span')
            html.innerText = str
            html.className = 'getTextWidth'
            document.querySelector('body').appendChild(html)
            width = document.querySelector('.getTextWidth').offsetWidth
            document.querySelector('.getTextWidth').remove()
            return width
        },
        deleteRow(index, rows) {
            rows.splice(index, 1)
        },
        // 1. 定义getUserList方法 获取后台服务器数据
        async getUser() {
            // 新增操作请求的类型: post  接收时需要使用JSON方式处理
            let {
                data: result
            } = await axios.get('/queryAll')
            // Ajax调用之后, 将请求结果赋值给data属性
            let keys = []
            for (let property in result.data[0]) {
                keys.push(property)
            }
            // console.log(keys)
            this.pageFormHead = keys
            this.data = result.data
            // idea about getting data
            // let values = function(object) {
            //     let values = []
            //     for (let property in object)
            //         values.push(object[property])
            //     return values
            // }
            //
            // // 写成标准的方法(数组是object的一种)：
            // function getObjectKeys(object) {
            //     let keys = []
            //     for (let property in object)
            //         keys.push(property)
            //     return keys
            // }
            //
            // function getObjectValues(object) {
            //     let values = []
            //     for (let property in object)
            //         values.push(object[property])
            //     return values
            // }
            // console.log(fields[0]['label'])
            // console.log(getObjectKeys(result.data[0]))
            // console.log(getObjectValues(result.data[0]))
        },
        async handleButtonQuery() {
            this.pageQueryValue.valueStatus = this.options.label
            var data = this.pageQueryValue
            axios({
                method: 'post',
                url: '/queryNameAndStatus',
                data: data
            }).then(function(response) {
                console.log(response)
            }).catch(function(error) {
                console.log(error)
            })

        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.inLine {
    display: inline-block;
}
</style>
