import Layout from '@/layout'
import EmptyLayout from '@/layout/empty'
// still under construction

export default {
    path: '/multilevel_menu_hr',
    component: Layout,
    redirect: '/multilevel_menu_hr/index',
    name: 'multilevelMenuHR',
    meta: {
        title: '人事功能',
        icon: 'person-hr'
    },
    children: [
        {
            path: 'index',
            name: 'HumanResourcesIndex',
            component: EmptyLayout,
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '人力资源信息总览',
                sidebar: false,
                breadcrumb: false
            }
        },
        {
            path: 'recruitment',
            name: 'RecruitmentManagement',
            component: EmptyLayout,
            // redirect: '/multilevel_menu_basic/management/global_dic',
            redirect: '',
            meta: {
                title: '招聘管理'
            },
            children: [
                {
                    path: 'overview',
                    name: 'RecruitmentOverview',
                    component: EmptyLayout,
                    meta: {
                        title: '管理总览',
                        sidebar: true,
                        breadcrumb: true
                    },
                    children: [
                        {
                            path: 'vacancies',
                            name: 'Vacancies',
                            component: () => import('@/views/human_resources/recruitment/vacancies'),
                            meta: {
                                title: '职位空缺发布',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'recruitment',
                            name: 'RecruitmentInterviewManagement',
                            component: () => import('@/views/human_resources/recruitment/recruitment'),
                            meta: {
                                title: '招聘面试管理',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'resume',
                            name: 'ResumeCollectionFilter',
                            component: () => import('@/views/test'),
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '简历筛选录用',
                                sidebar: true,
                                breadcrumb: true
                            }
                        }
                    ]
                },
                {
                    path: 'channel',
                    name: 'ChannelManagement',
                    component: EmptyLayout,
                    redirect: '',
                    meta: {
                        title: '渠道管理',
                        sidebar: true,
                        breadcrumb: true
                    },
                    children: [
                        {
                            path: 'enterprise',
                            name: 'EnterpriseRecruitmentPortal',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '企业招聘门户',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'internal',
                            name: 'InternalReferralChannel',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '内部推荐渠道',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'third',
                            name: 'ThirdPartyProvider',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '第三方供应商',
                                sidebar: true,
                                breadcrumb: true
                            }
                        }
                    ]
                },
                {
                    path: 'report',
                    name: 'StatisticalReport',
                    component: EmptyLayout,
                    redirect: '',
                    meta: {
                        title: '统计报表',
                        sidebar: true,
                        breadcrumb: true
                    },
                    children: [
                        {
                            path: 'external',
                            name: 'ExternalTalentPoolInventoryReport',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '外库盘点报表',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'effectiveness',
                            name: 'RecruitmentChannelEffectivenessAnalysis',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '渠道有效分析',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'analysis',
                            name: 'RecruitmentCycleAnalysis',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '周期成本分析',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'task',
                            name: 'RecruitmentTaskStatistics',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '招聘任务统计',
                                sidebar: true,
                                breadcrumb: true
                            }
                        }
                    ]
                }
            ]
        },
        {
            path: 'salary',
            name: 'SalaryManagement',
            component: EmptyLayout,
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '薪资管理',
                sidebar: true,
                breadcrumb: true
            },
            children: [
                {
                    path: 'summary',
                    name: 'SalarySummary',
                    // component: () => import('@/views/index'),
                    redirect: '',
                    meta: {
                        title: '薪资信息汇总',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'adjustment',
                    name: 'SalaryAdjustment',
                    // component: () => import('@/views/index'),
                    redirect: '',
                    meta: {
                        title: '薪资具体调整', // 扣款 奖惩 个人所得
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'tax',
                    name: 'SalaryTaxCalculation',
                    // component: () => import('@/views/index'),
                    redirect: '',
                    meta: {
                        title: '薪资具体计税',
                        sidebar: true,
                        breadcrumb: true
                    }
                }
            ]
        },
        {
            path: 'attendance',
            name: 'AttendanceManagement',
            component: EmptyLayout,
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '考勤管理',
                sidebar: true,
                breadcrumb: true
            },
            children: [
                {
                    path: 'settings',
                    name: 'BasicDataSettings',
                    // component: () => import('@/views/index'),
                    redirect: '',
                    meta: {
                        title: '基础数据设置',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'business',
                    name: 'AttendanceBusinessProcessing',
                    // component: () => import('@/views/index'),
                    redirect: '',
                    meta: {
                        title: '考勤业务处理',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'record',
                    name: 'AttendanceRecordStatistics',
                    // component: () => import('@/views/index'),
                    redirect: '',
                    meta: {
                        title: '考勤记录统计',
                        sidebar: true,
                        breadcrumb: true
                    }
                }
            ]
        },
        {
            path: 'training',
            name: 'TrainingManagement',
            component: EmptyLayout,
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '培训管理',
                sidebar: true,
                breadcrumb: true
            },
            children: [
                {
                    path: 'overview',
                    name: 'TrainingInformationOverview',
                    // component: () => import('@/views/index'),
                    redirect: '',
                    meta: {
                        title: '培训详情总览',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'list',
                    name: 'TrainingContentsList',
                    // component: () => import('@/views/index'),
                    redirect: '',
                    meta: {
                        title: '培训内容清单',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'results',
                    name: 'TrainingResultsStatistics',
                    // component: () => import('@/views/index'),
                    redirect: '',
                    meta: {
                        title: '培训结果统计',
                        sidebar: true,
                        breadcrumb: true
                    }
                }
            ]
        },
        {
            path: 'performance',
            name: 'PerformanceManagement',
            component: EmptyLayout,
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '绩效管理',
                sidebar: true,
                breadcrumb: true
            }
        },
        {
            path: 'background',
            name: 'BackgroundInvestigationManagement',
            component: EmptyLayout,
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '背调管理',
                sidebar: true,
                breadcrumb: true
            }
        }
    ]
}
