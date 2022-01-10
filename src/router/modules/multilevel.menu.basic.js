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
        icon: 'sidebar-menu'
    },
    children: [
        {
            //    模块(1) 信息总览010101
            path: 'overview',
            name: 'InformationChartOverview',
            component: () => import('@/views/index'),
            meta: {
                title: '基本信息总览'
            }
        },
        {
            //    模块(3) 字典 通知 基础
            path: 'management',
            name: 'SystemFeaturesManagement',
            component: EmptyLayout,
            redirect: '',
            meta: {
                title: '系统功能管理'
            },
            children: [
                {
                    path: 'dic',
                    name: 'Dictionary',
                    component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                    meta: {
                        title: '数据字典'
                        //    前端功能要求1 设计交互页面
                        //    前端功能要求2 完善访问路径
                        //    后端功能要求1 实现用户字典
                    }
                },
                {
                    path: 'notice',
                    name: 'Notification',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedSetting'),
                    meta: {
                        title: '系统通知'
                        //    前端功能要求1 设计交互页面
                        //    前端功能要求2 完善访问路径
                        //    后端功能要求1 实现通知管理(全局/指定)
                    }
                },
                {
                    path: 'basic',
                    name: 'Basic',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedSetting'),
                    meta: {
                        title: '基础设置'
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
            // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/bankAccountManagement'),
            meta: {
                title: '账户内容管理'
            },
            children: [
                {
                    path: 'personal',
                    name: 'Personal',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedAlert'),
                    meta: {
                        title: '个人账户'
                    //    前端功能要求1 根据登录账户判断是否为改角色 完善访问路径和交互页面
                    //    后端功能要求1 实现 角色,权限,用户,绩效,背调 功能
                    }
                },
                {
                    path: 'enterprises',
                    name: 'Enterprises',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedSetting'),
                    meta: {
                        title: '企业账户'
                    //    前端功能要求1 根据登录账户判断是否为改角色 完善访问路径和交互页面
                    //    后端功能要求1 实现 角色,权限,用户,绩效,背调 功能 人员管理
                    //    后端2 企业基础信息及设置
                    }
                },
                {
                    path: 'security',
                    name: 'Security',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedSetting'),
                    meta: {
                        title: '安全设置'
                        //    前端功能要求1 根据登录账户判断是否为改角色 完善访问路径和交互页面
                        //    后端功能要求1 实现 角色,权限,用户,绩效,背调 功能
                        //    后端2 企业基础信息及设置,安全设置
                    }
                }
            ]
        },
        {
            //    模块(4) 日志,监控,数统,脱敏
            path: 'monitor_manage',
            name: 'MonitoringManagement',
            // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/bankAccountManagement'),
            meta: {
                title: '账户监控管理'
            },
            children: [
                {
                    path: 'log',
                    name: 'Logging',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedAlert'),
                    meta: {
                        title: '系统日志'
                        //    前端功能要求1  完善访问路径和交互页面
                        //    后端功能要求1  日志
                    }
                },
                {
                    path: 'monitor',
                    name: 'Monitoring',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedSetting'),
                    meta: {
                        title: '监控设置'
                        //    前端功能要求1 完善访问路径和交互页面
                        //    后端功能要求1 行为监控
                    }
                },
                {
                    path: 'statistic',
                    name: 'Statistics',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedSetting'),
                    meta: {
                        title: '数据统计'
                        //    前端功能要求1 完善访问路径和交互页面
                        //    后端功能要求1 统计
                    }
                },
                {
                    path: 'desensitize',
                    name: 'Desensitization',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedSetting'),
                    meta: {
                        title: '数据脱敏'
                        //    前端功能要求1 完善访问路径和交互页面
                        //    后端功能要求1 数据脱敏
                    }
                }
            ]
        },
        {
            //    模块(1) 帮助
            path: 'help',
            name: 'HelpManagement',
            // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/bankAccountManagement'),
            meta: {
                title: '支援以及帮助'
            },
            children: [
                {
                    path: 'manual',
                    name: 'Manual',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedAlert'),
                    meta: {
                        title: '使用手册'
                        //    前端功能要求1  完善访问路径和交互页面
                        //    后端功能要求1  个人以及企业
                    }
                },
                {
                    path: 'online',
                    name: 'Intelligence',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedSetting'),
                    meta: {
                        title: '在线助理'
                        //    前端功能要求1 完善访问路径和交互页面
                        //    后端功能要求1 AI
                    }
                },
                {
                    path: 'artificial',
                    name: 'Artificiality',
                    // component: () => import('@/views/multilevel_menu_example/foundation/foundation_sub/advancedSetting'),
                    meta: {
                        title: '人工客服'
                        //    前端功能要求1 完善访问路径和交互页面
                        //    后端功能要求1 及时聊天
                    }
                }
            ]
        }
    ]
}