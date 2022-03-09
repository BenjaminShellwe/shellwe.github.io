<template>
    <div>
        <page-header title="人工客服">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为系统人工客服 本页面还在设计中 人工客服由人事部门管理
                </div>
            </template>
        </page-header>
        <page-main>
            <el-descriptions title="今日值班管理人员" :column="3" :size="size" class="pageDescriptionsCSS" border>
                <template slot="extra">
                    <el-dropdown>
                        <el-button type="primary">
                            操作<i class="el-icon-arrow-down el-icon--right"></i>
                        </el-button>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>预设值班</el-dropdown-item>
                            <el-dropdown-item>更改值班</el-dropdown-item>
                            <el-dropdown-item>更改信息</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </template>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-user"></i>
                        用户名
                    </template>
                    benjamin shellwe
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>
                        值班电话号码
                    </template>
                    17654321123
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-document"></i>
                        部门
                    </template>
                    人事部
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-tickets"></i>
                        备注
                    </template>
                    <el-tag size="small">人事主管</el-tag>
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-office-building"></i>
                        值班地点
                    </template>
                    非值班室值班 请 预约联系(*)
                </el-descriptions-item>
            </el-descriptions>
            <el-descriptions title="今日值班人员" :column="3" :size="size" class="pageDescriptionsCSS" border>
                <template slot="extra">
                    <el-dropdown>
                        <el-button type="primary">
                            操作<i class="el-icon-arrow-down el-icon--right"></i>
                        </el-button>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>更改值班信息</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </template>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-user"></i>
                        用户名
                    </template>
                    benjamin thomas
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-mobile-phone"></i>
                        值班电话号码
                    </template>
                    17654321153
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-document"></i>
                        部门
                    </template>
                    人事部
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-tickets"></i>
                        备注
                    </template>
                    <el-tag size="small">人事员工</el-tag>
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        <i class="el-icon-office-building"></i>
                        值班地点
                    </template>
                    值班室值班 请 前往 值班室预约
                </el-descriptions-item>
            </el-descriptions>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Artificial',
    components: {PageMain, PageHeader},
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
.pageDescriptionsCSS {
    margin-bottom: 10px;
}
</style>
