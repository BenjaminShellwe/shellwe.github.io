<template>
    <div>
        <page-header title="企业账户">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为企业账户的基本设置
                </div>
            </template>
        </page-header>
        <page-main title="注意,本页面所有功能都处于开发阶段,因为本页内容相对较多,故不会为所有操作提供事件监听!">
            <el-row :gutter="10" style="margin-bottom: 5px;">
                <el-col>
                    <el-card>
                        <el-descriptions class="margin-top" title="企业基本信息" :column="3" :size="size" border>
                            <template slot="extra">
                                <el-button type="primary" size="small">操作</el-button>
                            </template>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-user" />
                                    名称
                                </template>
                                TernaryProjectTeam
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-mobile-phone" />
                                    联系
                                </template>
                                shellwe.top
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-location-outline" />
                                    地址
                                </template>
                                湛江市
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-tickets" />
                                    备注
                                </template>
                                <el-tag size="small">企业</el-tag>
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-office-building" />
                                    联系地址
                                </template>
                                广东省广州市从化区广从南路 548 号
                            </el-descriptions-item>
                        </el-descriptions>
                    </el-card>
                </el-col>
            </el-row>
            <el-row :gutter="10" style="margin-bottom: 5px;">
                <el-col :span="3">
                    <el-card>
                        <h3>企业基本信息</h3>
                    </el-card>
                </el-col>
                <el-col :span="21">
                    <el-card>
                        企业基本信息
                    </el-card>
                </el-col>
            </el-row>
            <el-row :gutter="10" style="margin-bottom: 5px;">
                <div v-show="page.loginButton" class="pageStyle">此语句应该绑定一个登录验证事件</div>
                <el-button-group v-show="page.loginButton">
                    <el-button type="primary" size="mini" class="pageStyle" @click="pageLogin('E')">登录企业管理账户</el-button>
                    <el-button type="primary" size="mini" @click="pageLogin('P')">登录企业个人账户</el-button>
                </el-button-group>
                <div v-show="page.content">
                    <el-col><span>statement:double click would closed the window button create.</span></el-col>
                    <el-col>
                        <el-card>
                            <el-button-group style="margin-right: 10px;">
                                <el-button type="success" plain @click="pageValueChange('user')">用户信息总览(用户)</el-button>
                                <el-button type="primary" plain @click="pageValueChange('background')">背调信息总览(背调)</el-button>
                            </el-button-group>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <el-button-group style="margin-right: 10px;">
                                <el-button type="success" plain @click="pageValueChange('role')">角色信息总览(角色)</el-button>
                                <el-button type="primary" plain @click="pageValueChange('permission')">权限控制总览(权限)</el-button>
                                <el-button type="warn" plain @click="pageValueChange('performance')">绩效信息总览(绩效)</el-button>
                            </el-button-group>
                        </el-card>
                    </el-col>
                    <el-col v-if="page.subContent.user">
                        content of 用户信息总览(用户)
                    </el-col>
                    <el-col v-if="page.subContent.background">
                        content of 背调信息总览(背调)
                    </el-col>
                    <el-col v-if="page.subContent.role">
                        content of 角色信息总览(角色)
                    </el-col>
                    <el-col v-if="page.subContent.permission">
                        content of 权限控制总览(权限)
                    </el-col>
                    <el-col v-if="page.subContent.performance">
                        content of 绩效信息总览(绩效)
                    </el-col>
                    <el-col v-if="page.subContent.remain">
                        content of 保留内容
                    </el-col>
                </div>
            </el-row>
        </page-main>
        <el-dialog
            title="来自shellwe的警告"
            :visible.sync="dialogVisible"
            width="30%"
        >
            <span>
                开发中 暂时拒绝提交至后台 数据未更改<br>
                此页面将会优先开发企业页面
            </span>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    data() {
        return {
            dialogVisible: false,
            size: '',
            page: {
                content: false,
                loginButton: true,
                subContent: {
                    user: false,
                    background: false,
                    role: false,
                    permission: false,
                    performance: false,
                    remain: false
                }
            }
        }
    },
    methods: {

        back() {
            history.go(-1)
        },
        pageLogin(val) {
            if (val == 'E') {
                this.page.loginButton = false
                this.page.content = true
            } if (val == 'P') {
                this.page.loginButton = false
                this.dialogVisible = true
                this.page.loginButton = true
            }
        },
        pageValueChange(val) {
            let value = new Boolean(value)
            value = this.page.subContent[val]
            this.$set(this.page.subContent, val, !value)
            console.log(this.page.subContent)
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.pageStyle {
    margin-left: 5px;
    margin-bottom: 5px;
}
</style>
