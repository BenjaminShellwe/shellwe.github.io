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
                    <span v-auth="'permission.browse'">
                        (可见即拥有 Basic权限  基本访问)
                    </span>
                </div>
            </template>
        </page-header>
        <page-main title="权限数据统计">
            {{ $store.state.settings.permissions }}
            <el-card shadow="hover">
                <el-form :model="search" size="small" label-width="180px">
                    <span>权限授予目前是固定在Vue.js前端方便演示</span>
                    <el-row>
                        <el-col :span="8">
                            <el-tooltip class="item" effect="dark" content="进阶选项 部门 需要Intermediate或以上等级" placement="top">
                                <el-form-item v-auth="'permission.edit'" label="Intermediate或以上等级">
                                    <el-select v-model="search.department_id" clearable placeholder="演示框1">
                                        <el-option label="所选择不影响后台" :value="1" />
                                        <el-option label="所选择不影响后台" :value="2" />
                                        <el-option label="所选择不影响后台" :value="3" />
                                    </el-select>
                                    <br>
                                    <span v-auth-all="['permission.basic',
                                                       'permission.create',
                                                       'permission.edit',
                                                       'permission.remove',
                                                       'permission.access',
                                                       'permission.department'
                                    ]"
                                    >
                                        (可见即拥有需要Intermediate或以上 !!目前本账号拥有最高权限!!仅fip-admin,不与spring boot复合)
                                    </span>
                                </el-form-item>
                            </el-tooltip>
                        </el-col>
                        <el-col :span="8">
                            <el-tooltip class="item" effect="dark" content="进阶选项 职位 需要Elementary或以上等级" placement="top">
                                <el-form-item v-auth="['permission.browse', 'permission.create']" label="Elementary或以上等级">
                                    <el-select v-model="search.department_job_id" clearable placeholder="演示框2">
                                        <el-option label="所选择不影响后台" :value="1" />
                                        <el-option label="所选择不影响后台" :value="2" />
                                        <el-option label="所选择不影响后台" :value="3" />
                                    </el-select>
                                    <br>
                                    <span v-auth="['permission.browse', 'permission.create']">
                                        (可见即拥有 Elementary权限  中阶权限)
                                    </span>
                                </el-form-item>
                            </el-tooltip>
                        </el-col>
                        <el-col :span="8">
                            <el-tooltip class="item" effect="dark" content="进阶选项 角色 需要Primary或以上等级" placement="top">
                                <el-form-item v-auth="'permission.create'" label="Primary或以上等级">
                                    <el-select v-model="search.role_id" clearable placeholder="演示框3">
                                        <el-option label="所选择不影响后台" :value="1" />
                                        <el-option label="所选择不影响后台" :value="2" />
                                    </el-select>
                                    <br>
                                    <span v-auth="'permission.create'">
                                        (可见即拥有 Primary权限  初级权限)
                                    </span>
                                </el-form-item>
                            </el-tooltip>
                        </el-col>
                    </el-row>
                </el-form>
            </el-card>
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
