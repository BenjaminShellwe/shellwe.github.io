import Layout from '@/layout'
import EmptyLayout from '@/layout/empty'
// still under construction

export default {
    path: '/multilevel_menu_basic',
    component: Layout,
    redirect: '/multilevel_menu_basic/overview',
    name: 'multilevelMenuBasic',
    meta: {
        title: '基础功能',
        icon: 'sidebar-menu',
        auth: ['permission.basic']
    },
    children: [
        {
            //    模块(1) 信息总览010101
            path: 'overview',
            name: 'InformationChartOverview',
            component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '基本信息总览',
                sidebar: false,
                breadcrumb: false
            }
        },
        {
            //    模块(3) 字典 通知 基础
            path: 'management',
            name: 'SystemFeaturesManagement',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/management/global_dic',
            meta: {
                title: '系统功能管理'
            },
            children: [
                {
                    path: 'global_dic',
                    name: 'Dictionary_G',
                    component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                    meta: {
                        title: '数据字典',
                        sidebar: true,
                        breadcrumb: true
                        //    前端功能要求1 设计交互页面
                        //    前端功能要求2 完善访问路径
                        //    后端功能要求1 实现用户字典
                    }
                },
                {
                    path: 'personal_dic',
                    name: 'Dictionary_P',
                    component: () => import('@/views/global_func_manage/data_dic/personal_dic'),
                    meta: {
                        title: '个人字典',
                        sidebar: false,
                        breadcrumb: false
                    }
                },
                {
                    path: 'notice',
                    name: 'Notification',
                    component: () => import('@/views/global_func_manage/message/global_message'),
                    meta: {
                        title: '系统通知',
                        sidebar: true,
                        breadcrumb: true
                        //    前端功能要求1 设计交互页面
                        //    前端功能要求2 完善访问路径
                        //    后端功能要求1 实现通知管理(全局/指定)
                    }
                },
                {
                    path: 'basic',
                    name: 'Basic',
                    component: () => import('@/views/global_func_manage/basic_settings/basic'),
                    meta: {
                        title: '基础设置',
                        sidebar: true,
                        breadcrumb: true
                        //    前端功能要求1 设计交互页面
                        //    前端功能要求2 完善访问路径
                        //    后端功能要求1 首页 菜单等
                    }
                }
            ]
        },
        {
            //    模块(7) 角色,权限,用户,绩效,背调,安全,人管
            path: 'account_management',
            name: 'AccountContentManagement',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/account_management/personal',
            meta: {
                title: '账户内容管理',
                sidebar: true,
                breadcrumb: true
            },
            children: [
                {
                    path: 'personal',
                    name: 'Personal',
                    component: () => import('@/views/personal/setting'),
                    meta: {
                        title: '个人设置',
                        sidebar: true,
                        breadcrumb: true
                    //    前端功能要求1 根据登录账户判断是否为改角色 完善访问路径和交互页面
                    //    后端功能要求1 实现 角色,权限,用户,绩效,背调 功能
                    }
                },
                {
                    path: 'enterprises',
                    name: 'Enterprises',
                    component: () => import('@/views/account_management/enterprises/enterprises'),
                    meta: {
                        title: '企业账户',
                        sidebar: true,
                        breadcrumb: true
                    //    前端功能要求1 根据登录账户判断是否为改角色 完善访问路径和交互页面
                    //    后端功能要求1 实现 角色,权限,用户,绩效,背调 功能 人员管理
                    //    后端2 企业基础信息及设置
                    }
                },
                {
                    path: 'security',
                    name: 'Security',
                    component: () => import('@/views/account_management/security/security'),
                    meta: {
                        title: '安全设置',
                        sidebar: true,
                        breadcrumb: true,
                        auth: ['permission.access']
                    }
                }
            ]
        },
        {
            //    模块(4) 日志,监控,数统,脱敏
            path: 'monitor_manage',
            name: 'MonitoringManagement',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/monitor_manage/log',
            meta: {
                title: '账户监控管理'
            },
            children: [
                {
                    path: 'log',
                    name: 'Logging',
                    component: () => import('@/views/monitor_manage/log/log'),
                    meta: {
                        title: '系统日志',
                        sidebar: true,
                        breadcrumb: true
                        //    前端功能要求1  完善访问路径和交互页面
                        //    后端功能要求1  日志
                    }
                },
                {
                    path: 'monitor',
                    name: 'Monitoring',
                    component: () => import('@/views/monitor_manage/monitor/monitor'),
                    meta: {
                        title: '监控设置',
                        sidebar: true,
                        breadcrumb: true
                        //    前端功能要求1 完善访问路径和交互页面
                        //    后端功能要求1 行为监控
                    }
                },
                {
                    path: 'statistic',
                    name: 'Statistics',
                    component: () => import('@/views/monitor_manage/statistic/statistic'),
                    meta: {
                        title: '数据统计',
                        sidebar: true,
                        breadcrumb: true
                        //    前端功能要求1 完善访问路径和交互页面
                        //    后端功能要求1 统计
                    }
                },
                {
                    path: 'desensitize',
                    name: 'Desensitization',
                    component: () => import('@/views/monitor_manage/desensitize/desensitize'),
                    meta: {
                        title: '数据脱敏',
                        sidebar: true,
                        breadcrumb: true
                        //    前端功能要求1 完善访问路径和交互页面
                        //    后端功能要求1 数据脱敏
                    }
                }
            ]
        }
    ]
}
