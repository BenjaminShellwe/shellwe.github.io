import Layout from '@/layout'
import EmptyLayout from '@/layout/empty'

export default {
    path: '/multilevel_menu_advanced',
    component: Layout,
    redirect: '/multilevel_menu_advanced/list1',
    name: 'breadcrumbExample',
    meta: {
        title: '高级功能',
        icon: 'currency-yen'
    },
    children: [
        {
            path: 'list1',
            name: 'breadcrumbExampleList1',
            component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/example/breadcrumb_example/list1'),
            meta: {
                title: '列表1（平级模式）'
            }
        },
        {
            path: 'chat',
            name: 'ChatRoom',
            component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/global_func_manage/chat/chat'),
            meta: {
                title: '即时通信',
                sidebar: false,
                breadcrumb: false
            }
        },
        {
            path: 'detail1',
            name: 'breadcrumbExampleDetail1',
            component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/example/breadcrumb_example/detail1'),
            meta: {
                title: '详情1',
                sidebar: false,
                activeMenu: '/multilevel_menu_advanced/list1'
            }
        },
        {
            path: 'list2',
            name: 'breadcrumbExampleList2',
            component: EmptyLayout,
            redirect: '/multilevel_menu_advanced/list2',
            meta: {
                title: '列表2（层级模式）'
            },
            children: [
                {
                    path: '',
                    component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/example/breadcrumb_example/list2'),
                    meta: {
                        title: '列表2（层级模式）',
                        sidebar: false,
                        breadcrumb: false
                    }
                },
                {
                    path: 'detail2',
                    name: 'breadcrumbExampleDetail2',
                    component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/example/breadcrumb_example/detail2'),
                    meta: {
                        title: '详情2',
                        sidebar: false,
                        activeMenu: '/multilevel_menu_advanced/list2'
                    }
                }
            ]
        }
    ]
}
