import EmptyLayout from '@/layout/empty'

export default {
    path: '/permission_example',
    component: EmptyLayout,
    redirect: '/permission_example/index',
    name: 'permissionExample',
    meta: {
        title: '权限验证',
        icon: 'sidebar-permission',
        sidebar: true,
        breadcrumb: true
    },
    children: [
        {
            path: 'index',
            name: 'permissionExampleIndex',
            component: () => import(/* webpackChunkName: 'permission_example' */ '@/views/example/permission_example'),
            meta: {
                title: '权限验证',
                auth: ['permission.browse'],
                sidebar: true,
                breadcrumb: true,
                activeMenu: '/permission_example'
            }
        }
    ]
}
