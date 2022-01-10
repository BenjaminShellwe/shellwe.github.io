import Layout from '@/layout'

export default {
    path: '/mock_example',
    component: Layout,
    redirect: '/mock_example/index',
    name: 'mockExample',
    meta: {
        title: 'Mock',
        icon: 'sidebar-mock',
        badge: 'NEW',
        sidebar: false,
        breadcrumb: false
    },
    children: [
        {
            path: 'index',
            name: 'mockExampleIndex',
            component: () => import(/* webpackChunkName: 'mock_example' */ '@/views/example/mock_example'),
            meta: {
                title: 'Mock',
                sidebar: false,
                breadcrumb: false,
                activeMenu: '/mock_example'
            }
        }
    ]
}
