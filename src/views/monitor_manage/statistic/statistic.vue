<template>
    <div>
        <page-header title="数据统计">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为系统的数据统计
                    已登录账号所有权限{{ $store.state.settings.permissions }}
                    <div>
                        <span v-auth="'permission.browse'">
                            (Basic权限  基本访问)
                        </span>
                        <span v-auth="'permission.create'">
                            (Primary权限  初级权限)
                        </span>
                        <span v-auth="['permission.browse', 'permission.create']">
                            (Elementary权限  中阶权限)
                        </span>
                        <span v-auth-all="['permission.browse',
                                           'permission.create',
                                           'permission.edit',
                                           'permission.remove',
                                           'supplay.department.browse',
                                           'supplay.department_job.browse',
                                           'supplay.role.browse']"
                        >
                            (!!目前本账号拥有最高权限!!)
                        </span>
                    </div>
                </div>
            </template>
        </page-header>
        <page-main>
            <search-bar show-more @toggle="searchMore = $event">
                <el-form :model="search" size="small" label-width="120px">
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="工作记录">
                                <el-input v-model="search.name" placeholder="请输入姓名或者账户ID,暂不支持模糊查询(减少数据库负担),将根据您权限提供进阶选项" clearable />
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="6">
                            <el-tooltip class="item" effect="dark" content="进阶选项 部门 需要Intermediate或以上等级" placement="top">
                                <el-form-item v-auth="'supplay.department.browse'" label="部门">
                                    <el-select v-model="search.department_id" clearable placeholder="选择工作部门">
                                        <el-option label="技术部" :value="1" />
                                        <el-option label="教辅部" :value="2" />
                                        <el-option label="行政部" :value="3" />
                                    </el-select>
                                </el-form-item>
                            </el-tooltip>
                        </el-col>
                        <el-col :span="6">
                            <el-tooltip class="item" effect="dark" content="进阶选项 职位 需要Elementary或以上等级" placement="top">
                                <el-form-item v-auth="'supplay.department_job.browse'" label="职位">
                                    <el-select v-model="search.department_job_id" clearable placeholder="选择工作职位">
                                        <el-option label="程序员" :value="1" />
                                        <el-option label="教辅员" :value="2" />
                                        <el-option label="人事" :value="3" />
                                    </el-select>
                                </el-form-item>
                            </el-tooltip>
                        </el-col>
                        <el-col :span="6">
                            <el-tooltip class="item" effect="dark" content="进阶选项 角色 需要Primary或以上等级" placement="top">
                                <el-form-item v-auth="'supplay.role.browse'" label="角色">
                                    <el-select v-model="search.role_id" clearable placeholder="选择职员角色">
                                        <el-option label="主管" :value="1" />
                                        <el-option label="普通职员" :value="2" />
                                    </el-select>
                                </el-form-item>
                            </el-tooltip>
                        </el-col>
                    </el-row>
                    <el-row v-show="searchMore">
                        <el-col :span="24">
                            <el-form-item label="角色">
                                <el-checkbox :value="true">备选项</el-checkbox>
                                <el-checkbox :value="false">备选项</el-checkbox>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-form-item>
                        <el-button type="primary" icon="el-icon-search">筛选</el-button>
                        <el-button>导出</el-button>
                        <el-button type="text">查看已导出记录</el-button>
                    </el-form-item>
                </el-form>
            </search-bar>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Statistic',
    components: {PageMain, PageHeader},
    data() {
        return {
            search: {
                name: '',
                department_id: '',
                department_job_id: '',
                role_id: ''
            },
            searchMore: false
        }
    },
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
</style>
