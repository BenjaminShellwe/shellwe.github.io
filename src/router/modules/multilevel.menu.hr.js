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
        icon: 'person-hr',
        auth: ['permission.access']
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
                            component: () => import('@/views/basic_human_resources/recruitment/vacancies'),
                            meta: {
                                title: '职位空缺发布',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'recruitment',
                            name: 'RecruitmentInterviewManagement',
                            component: () => import('@/views/basic_human_resources/recruitment/recruitment'),
                            meta: {
                                title: '招聘面试管理',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'resume',
                            name: 'ResumeCollectionFilter',
                            component: () => import('@/views/basic_human_resources/recruitment/resume'),
                            meta: {
                                title: '简历筛选录用',
                                sidebar: true,
                                breadcrumb: true
                            }
                        },
                        {
                            path: 'builder',
                            name: 'ResumeBuilder',
                            component: () => import('@/views/basic_human_resources/recruitment/builder'),
                            meta: {
                                title: '简历生成工具',
                                sidebar: true,
                                breadcrumb: false,
                                auth: ['permission.edit']
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
                            component: () => import('@/views/basic_human_resources/recruitment/enterprise'),
                            meta: {
                                title: '企业招聘门户',
                                sidebar: true,
                                breadcrumb: true,
                                auth: ['permission.edit']
                            }
                        },
                        {
                            path: 'background',
                            name: 'BackgroundInvestigationManagement',
                            component: () => import('@/views/basic_human_resources/background/background'),
                            redirect: '',
                            meta: {
                                title: '背景调查管理',
                                sidebar: true,
                                breadcrumb: true
                            }
                        }
                    ]
                },
                {
                    path: 'report',
                    name: 'StatisticalReport',
                    component: () => import('@/views/basic_human_resources/recruitment/report'),
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
                            component: () => import('@/views/extra_functions/test'),
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '外库盘点报表',
                                sidebar: false,
                                breadcrumb: false,
                                auth: ['permission.edit']
                            }
                        },
                        {
                            path: 'effectiveness',
                            name: 'RecruitmentChannelEffectivenessAnalysis',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '渠道有效分析',
                                sidebar: false,
                                breadcrumb: false,
                                auth: ['permission.edit']
                            }
                        },
                        {
                            path: 'analysis',
                            name: 'RecruitmentCycleAnalysis',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '周期成本分析',
                                sidebar: false,
                                breadcrumb: false,
                                auth: ['permission.edit']
                            }
                        },
                        {
                            path: 'task',
                            name: 'RecruitmentTaskStatistics',
                            // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                            meta: {
                                title: '招聘任务统计',
                                sidebar: false,
                                breadcrumb: false,
                                auth: ['permission.edit']
                            }
                        }
                    ]
                }
            ]
        },
        {
            path: 'employee',
            name: 'EmployeeManagement',
            component: EmptyLayout,
            // redirect: '/multilevel_menu_basic/management/global_dic',
            redirect: '',
            meta: {
                title: '员工管理'
            },
            children: [
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
                            component: () => import('@/views/basic_human_resources/training/overview'),
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
                                sidebar: false,
                                breadcrumb: false
                            }
                        },
                        {
                            path: 'results',
                            name: 'TrainingResultsStatistics',
                            // component: () => import('@/views/index'),
                            redirect: '',
                            meta: {
                                title: '培训结果统计',
                                sidebar: false,
                                breadcrumb: false
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
                            path: 'setting',
                            name: 'BasicDataSettings',
                            component: () => import('@/views/basic_human_resources/attendance/setting'),
                            redirect: '',
                            meta: {
                                title: '考勤业务设置',
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
                                sidebar: false,
                                breadcrumb: false
                            }
                        },
                        {
                            path: 'record',
                            name: 'AttendanceRecordStatistics',
                            // component: () => import('@/views/index'),
                            redirect: '',
                            meta: {
                                title: '考勤记录统计',
                                sidebar: false,
                                breadcrumb: false
                            }
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
                            component: () => import('@/views/basic_human_resources/salary/summary'),
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
                                sidebar: false,
                                breadcrumb: false
                            }
                        },
                        {
                            path: 'tax',
                            name: 'SalaryTaxCalculation',
                            // component: () => import('@/views/index'),
                            redirect: '',
                            meta: {
                                title: '薪资具体计税',
                                sidebar: false,
                                breadcrumb: false
                            }
                        }
                    ]
                },
                {
                    path: 'performance',
                    name: 'PerformanceManagement',
                    component: () => import('@/views/basic_human_resources/performance/performance'),
                    redirect: '',
                    meta: {
                        title: '绩效管理',
                        sidebar: true,
                        breadcrumb: true
                    }
                }
            ]
        }
    ]
}
