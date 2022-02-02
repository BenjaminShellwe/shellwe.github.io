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
            //    模块(1) 信息总览010101
            path: 'index',
            name: 'HumanResourcesIndex',
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
            meta: {
                title: '职员招聘管理'
            },
            children: [
                {
                    path: 'notset',
                    name: 'notset',
                    // component: () => import('@/views/global_func_manage/data_dic/global_dic'),
                    meta: {
                        title: '预留',
                        sidebar: true,
                        breadcrumb: true
                        //    前端功能要求1 设计交互页面
                        //    前端功能要求2 完善访问路径
                        //    后端功能要求1 实现用户字典
                    }
                }
            ]
        },
        {
            path: 'salary',
            name: 'SalaryManagement',
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '职工薪资管理',
                sidebar: true,
                breadcrumb: true
            }
        },
        {
            path: 'attendance',
            name: 'AttendanceManagement',
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '职工考勤管理',
                sidebar: true,
                breadcrumb: true
            }
        },
        {
            path: 'training',
            name: 'TrainingManagement',
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '职工培训管理',
                sidebar: true,
                breadcrumb: true
            }
        },
        {
            path: 'performance',
            name: 'PerformanceManagement',
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '职工绩效管理',
                sidebar: true,
                breadcrumb: true
            }
        },
        {
            path: 'background',
            name: 'BackgroundInvestigationManagement',
            // component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '背景调查管理',
                sidebar: true,
                breadcrumb: true
            }
        }
    ]
}
