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
        <page-main title="企业账户">
            <el-row :gutter="10" style="margin-bottom: 5px;">
                <el-button-group v-show="page.loginButton">
                    <el-button type="primary" size="mini" class="pageStyle" @click="pageLogin('E')">启用企业管理账户</el-button>
                    <el-button type="primary" size="mini" @click="pageLogin('P')">启用企业个人账户</el-button>
                </el-button-group>
            </el-row>
            <el-row v-show="pageRowVisible" :gutter="10" style="margin-bottom: 5px;">
                <el-col>
                    <el-card shadow="hover">
                        <el-descriptions class="margin-top" title="企业基本信息" :column="3" :size="size" border>
                            <template slot="extra">
                                <el-button type="primary" size="small" @click="reload(2)">刷 新</el-button>
                            </template>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="enterprise" />
                                    名 称
                                </template>
                                {{ pageValue.name }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="enterpriseID" />
                                    企业标识
                                </template>
                                {{ pageValue.id }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="representative" />
                                    企业法人
                                </template>
                                {{ pageValue.representative }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-location-outline" />
                                    地 址
                                </template>
                                {{ pageValue.location }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-tickets" />
                                    类 型
                                </template>
                                <el-tag size="small">{{ pageValue.type }}</el-tag>
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-office-building" />
                                    联系地址
                                </template>
                                {{ pageValue.address }}
                            </el-descriptions-item>
                        </el-descriptions>
                    </el-card>
                    <el-row>
                        <el-col :span="12">
                            <el-card shadow="hover" style="margin-top: 5px;">
                                <el-table
                                    :data="pageTableData.filter(data => !pageSearch || data.name.toLowerCase().includes(pageSearch.toLowerCase()))"
                                    style="width: 100%;"
                                >
                                    <el-table-column
                                        label="职员ID"
                                        prop="userID"
                                    />
                                    <el-table-column
                                        label="账户状态"
                                        prop="status"
                                    />
                                    <el-table-column
                                        label="职员名称"
                                        prop="realName"
                                    />
                                    <el-table-column
                                        align="right"
                                    >
                                        <template slot="header">
                                            <el-input
                                                v-model="pageSearch"
                                                size="mini"
                                                placeholder="输入关键字搜索"
                                                style="width: 135px;"
                                            />
                                        </template>
                                    </el-table-column>
                                </el-table>
                            </el-card>
                        </el-col>
                        <el-col :span="12">
                            <el-card shadow="hover" style="margin-top: 5px; margin-left: 5px;">
                                <div class="Echarts">
                                    <div id="chartsUni" style="width: 705px; height: 373px;" />
                                </div>
                            </el-card>
                        </el-col>
                    </el-row>
                </el-col>
            </el-row>
            <el-row v-show="pageRowVisibleUni" :gutter="10" style="margin-bottom: 5px;">
                <el-col>
                    <el-card shadow="hover">
                        <el-descriptions class="margin-top" title="企业职员信息" :column="3" :size="size" border>
                            <template slot="extra">
                                <el-button type="primary" size="small" @click="reload(2)">刷 新</el-button>
                            </template>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-user" />
                                    职员姓名
                                </template>
                                {{ pageValueUni.realName }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-mobile" />
                                    工作电话
                                </template>
                                {{ pageValueUni.phone }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="representative" />
                                    所属职位
                                </template>
                                <el-tag size="small">{{ pageValueUni.position }}</el-tag>
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-location-outline" />
                                    备注信息
                                </template>
                                {{ pageValueUni.remarks }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-tickets" />
                                    企业名称
                                </template>
                                <el-tag size="small">{{ pageValueUni.enterpriseName }}</el-tag>
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-office-building" />
                                    账号状态
                                </template>
                                {{ pageValueUni.status }}
                            </el-descriptions-item>
                        </el-descriptions>
                    </el-card>
                </el-col>
            </el-row>
            <el-row>
                <el-col>
                    <el-card shadow="hover">
                        公司状态
                    </el-card>
                </el-col>
            </el-row>
            <el-row>
                <el-col>
                    <el-card shadow="hover">
                        员工录入 编辑  权限授予
                    </el-card>
                </el-col>
            </el-row>
            <el-row>
                <el-col>
                    <el-card shadow="hover">
                        员工工作日程 事务申请 状态提交 编辑 (辞职,信息)
                    </el-card>
                </el-col>
            </el-row>
            <div v-show="page.content">
                <el-col><span>statement:double click would closed the window button create.</span></el-col>
                <el-col>
                    <el-card>
                        <el-button-group style="margin-right: 10px;">
                            <el-button type="success" plain @click="pageValueChange('user')">用户信息总览(用户)</el-button>
                            <el-button type="primary" plain @click="pageValueChange('background')">背调信息总览(背调)</el-button>
                        </el-button-group>
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
import axios from 'axios'
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    inject: ['reload'],
    data() {
        return {
            dialogVisible: false,
            pageRowVisible: false,
            pageRowVisibleUni: false,
            size: 'small',
            pageSearch: '',
            pageTableData: [{}],
            pageValue: {
                enterpriseID: '数据脱敏处理Example',
                name: '数据脱敏处理Example',
                id: '数据脱敏处理Example',
                representative: '数据脱敏处理Example',
                location: '数据脱敏处理Example',
                type: '数据脱敏处理Example',
                address: '数据脱敏处理Example'
            },
            pageValueUni: {
                department: '数据脱敏处理Example',
                enterpriseID: '数据脱敏处理Example',
                enterpriseName: '数据脱敏处理Example',
                id: '数据脱敏处理Example',
                phone: '数据脱敏处理Example',
                position: '数据脱敏处理Example',
                realName: '数据脱敏处理Example',
                remarks: '数据脱敏处理Example',
                status: '数据脱敏处理Example',
                userID: '数据脱敏处理Example'
            },
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
    created() {
    },
    mounted() {
        this.echartsUni()
    },
    methods: {
        back() {
            history.go(-1)
        },
        pageLogin(val) {
            if (val == 'E') {
                const that = this
                axios({
                    method: 'post',
                    url: '/queryInfo/employee',
                    data: {
                        userID: this.$store.state.user.id
                    }
                }).then(function(response) {
                    that.pageValue.enterpriseID = response.data.data[0].enterpriseID
                    // console.log(that.pageValue.enterpriseID)
                    axios({
                        method: 'post',
                        url: '/enterprise/query/Info',
                        data: {
                            userID: that.pageValue.enterpriseID
                            // 测试数据
                            // userID: 123654
                        }
                    }).then(function(response) {
                        // console.log(response.data.data)
                        if (response.data.data == null) {
                            that.$message(response.data.msg)
                        } else {
                            that.pageRowVisible = true
                            that.pageValue = response.data.data[0]
                            // console.log(response.data.data)
                            // console.log(that.pageValue.)
                            // that.page.loginButton = false
                            axios({
                                method: 'post',
                                url: '/queryInfo/enterprise',
                                data: {
                                    enterpriseID: response.data.data[0].id
                                }
                            }).then(function(response) {
                                // console.log(response)
                                that.pageTableData = response.data.data
                            }).catch(function(error) {
                                console.log(error)
                            })
                        }
                    }).catch()
                }).catch(function(error) {
                    console.log(error)
                })
                // this.page.loginButton = false
                // this.page.content = true
            } if (val == 'P') {
                const that = this
                axios({
                    method: 'post',
                    url: '/queryInfo/employee',
                    data: {
                        userID: this.$store.state.user.id
                    }
                }).then(function(response) {
                    if (response.data.data == null) {
                        that.$message(response.data.msg)
                    }
                    that.pageValueUni = response.data.data[0]
                    that.pageRowVisibleUni = true
                }).catch(function(error) {
                    console.log(error)
                })
                // this.page.loginButton = false
                // this.dialogVisible = true
                // this.page.loginButton = true
            }
        },
        pageValueChange(val) {
            let value = new Boolean(value)
            value = this.page.subContent[val]
            this.$set(this.page.subContent, val, !value)
            console.log(this.page.subContent)
        },
        handleGetValue() {
            axios({
                method: 'post',
                url: '/enterprise/update',
                data: {

                }
            }).then().catch()
        },
        echartsUni() {
            var chartUni = this.$echarts.init(document.getElementById('chartsUni'))
            const data = {
                name: 'Chief',
                children: [
                    {
                        name: 'Manager',
                        children: [
                            { name: 'Supervisor', value: 8833 },
                            { name: 'Employee', value: 1732 },
                            { name: 'Other', value: 3623 }
                        ]
                    },
                    {
                        name: 'Inspector',
                        children: [{ name: 'Manager', value: 9116 }, { name: 'Other', value: 3623 }]
                    }
                ]
            }
            var data2 = {
                name: 'flare',
                children: [
                    {
                        name: 'flex',
                        children: [{ name: 'FlareVis', value: 4116 }]
                    },
                    {
                        name: 'scale',
                        children: [
                            { name: 'IScaleMap', value: 2105 },
                            { name: 'LinearScale', value: 1316 },
                            { name: 'LogScale', value: 3151 },
                            { name: 'OrdinalScale', value: 3770 },
                            { name: 'QuantileScale', value: 2435 },
                            { name: 'QuantitativeScale', value: 4839 },
                            { name: 'RootScale', value: 1756 },
                            { name: 'Scale', value: 4268 },
                            { name: 'ScaleType', value: 1821 },
                            { name: 'TimeScale', value: 5833 }
                        ]
                    },
                    {
                        name: 'display',
                        children: [{ name: 'DirtySprite', value: 8833 }]
                    }
                ]
            }
            // 配置图表
            var option = {
                tooltip: {
                    trigger: 'item',
                    triggerOn: 'mousemove'
                },
                legend: {
                    top: '2%',
                    left: '3%',
                    orient: 'vertical',
                    data: [
                        {
                            name: 'tree1',
                            icon: 'rectangle'
                        },
                        {
                            name: 'tree2',
                            icon: 'rectangle'
                        }
                    ],
                    borderColor: '#c23531'
                },
                series: [
                    {
                        type: 'tree',
                        name: 'tree1',
                        data: [data],
                        top: '5%',
                        left: '7%',
                        bottom: '2%',
                        right: '60%',
                        symbolSize: 7,
                        label: {
                            position: 'left',
                            verticalAlign: 'middle',
                            align: 'right'
                        },
                        leaves: {
                            label: {
                                position: 'right',
                                verticalAlign: 'middle',
                                align: 'left'
                            }
                        },
                        emphasis: {
                            focus: 'descendant'
                        },
                        expandAndCollapse: true,
                        animationDuration: 550,
                        animationDurationUpdate: 750
                    },
                    {
                        type: 'tree',
                        name: 'tree2',
                        data: [data2],
                        top: '20%',
                        left: '60%',
                        bottom: '22%',
                        right: '18%',
                        symbolSize: 7,
                        label: {
                            position: 'left',
                            verticalAlign: 'middle',
                            align: 'right'
                        },
                        leaves: {
                            label: {
                                position: 'right',
                                verticalAlign: 'middle',
                                align: 'left'
                            }
                        },
                        expandAndCollapse: true,
                        emphasis: {
                            focus: 'descendant'
                        },
                        animationDuration: 550,
                        animationDurationUpdate: 750
                    }
                ]
            }
            chartUni.setOption(option)
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
