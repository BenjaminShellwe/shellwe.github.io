import Layout from '@/layout'

export default {
    path: '/link',
    component: Layout,
    name: 'externalLinkExample',
    meta: {
        title: '外链支持',
        icon: 'sidebar-external-link'
    },
    children: [
        {
            path: 'shellwe.top',
            meta: {
                title: 'shellwe'
            }
        }
    ]
}
