import Layout from '@/layout'
// import EmptyLayout from '@/layout/empty'

export default {
    path: '/help',
    component: Layout,
    name: 'externalLinkExample',
    redirect: '/help/index',
    meta: {
        title: '支援帮助',
        icon: 'sidebar-external-link'
    },
    children: [
        {
            path: 'index',
            name: 'Index',
            component: () => import('@/views/basic_help/index'),
            meta: {
                title: '帮助说明',
                sidebar: false,
                breadcrumb: true
                //    前端功能要求1  完善访问路径和交互页面
                //    后端功能要求1  个人以及企业
            }
        },
        {
            path: 'manual',
            name: 'Manual',
            component: () => import('@/views/basic_help/manual'),
            meta: {
                title: '使用手册',
                sidebar: true,
                breadcrumb: true
                //    前端功能要求1  完善访问路径和交互页面
                //    后端功能要求1  个人以及企业
            }
        },
        {
            path: 'online',
            name: 'Intelligence',
            component: () => import('@/views/basic_help/online'),
            meta: {
                title: '在线助理',
                sidebar: true,
                breadcrumb: true
                //    前端功能要求1 完善访问路径和交互页面
                //    后端功能要求1 AI
            }
        },
        {
            path: 'artificial',
            name: 'Artificiality',
            component: () => import('@/views/basic_help/artificial'),
            meta: {
                title: '人工客服',
                sidebar: true,
                breadcrumb: true
                //    前端功能要求1 完善访问路径和交互页面
                //    后端功能要求1 及时聊天
            }
        }
    ]
}
