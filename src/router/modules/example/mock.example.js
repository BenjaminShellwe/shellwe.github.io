import EmptyLayout from '@/layout/empty'

export default {
    path: '/mock_example',
    component: EmptyLayout,
    redirect: '/mock_example/index',
    name: 'mockExample',
    meta: {
        title: 'Mock',
        icon: 'sidebar-mock',
        badge: 'NEW',
        sidebar: true,
        breadcrumb: true
    },
    children: [
        {
            path: 'index',
            name: 'mockExampleIndex',
            component: () => import(/* webpackChunkName: 'mock_example' */ '@/views/example/mock_example'),
            meta: {
                title: 'Mock',
                sidebar: true,
                breadcrumb: true,
                activeMenu: '/mock_example'
            }
        }
    ]
}
