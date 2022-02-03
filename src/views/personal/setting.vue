<template>
    <div>
        <page-header title="个人账户">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为个人账户的基本设置 *本页面目前数据为固定数据,并没有接入数据库
                </div>
            </template>
        </page-header>
        <page-main>
            <el-tabs tab-position="left" style="height: auto; min-height: 600px;">
                <el-tab-pane label="基本设置" class="basic">
                    <h2>基本设置</h2>
                    <div>
                        <el-row :gutter="20" style="margin-top: 10px;">
                            <el-col :span="8">
                                <div>
                                    <el-card>
                                        <div slot="header">
                                            <el-row>
                                                <el-col :span="13">
                                                    <span>个人中心</span>
                                                </el-col>
                                                <el-col :span="11">
                                                    <image-upload :url.sync="form.headimg" action="http://scrm.1daas.com/api/upload/upload" name="image" :data="{'token':'TKD628431923530324'}" notip class="headimg-upload" @onSuccess="handleSuccess" />
                                                </el-col>
                                            </el-row>
                                        </div>
                                        <div>
                                            <span>登录人员 - {{ $store.state.user.account }}</span>
                                        </div>
                                        <div>
                                            <span>
                                                注册时间：2022/01/13 22:08:33
                                            </span>
                                        </div>
                                        <el-divider />
                                        <div>
                                            <div>手机号码:  <div style="float: right; padding-right: 20px;">{{ dataForm.phone }}</div></div>
                                        </div>
                                        <div>
                                            <div>所属企业:  <div style="float: right; padding-right: 20px;">TernaryProjectTeam</div></div>
                                        </div>
                                        <div>
                                            <div>首页链接:  <div style="float: right; padding-right: 20px;">{{ dataForm.homeUrl }}</div></div>
                                        </div>
                                    </el-card>
                                </div>
                            </el-col>
                            <el-col :span="16">
                                <div>
                                    <el-card>
                                        <div slot="header">
                                            <span>基本资料</span>
                                            <el-button v-show="editable" type="primary" size="mini" @click="changeEditable(1)">编辑</el-button>
                                            <el-button v-show="done" type="success" size="mini" @click="changeEditable(0)">完成</el-button>
                                        </div>
                                        <div>
                                            <el-form v-model="dataForm" label-width="100px" size="small" label-position="right">
                                                <div>
                                                    <el-form-item label="真实姓名" prop="nickName" class="inLine">
                                                        <el-input v-model="dataForm.realName" :disabled="editable" placeholder="请输入姓名" auto-complete="off" />
                                                    </el-form-item>
                                                    <el-form-item label="手机号码" prop="phone" class="inLine">
                                                        <el-input v-model="dataForm.phone" :disabled="editable" placeholder="请输入号码" auto-complete="off" />
                                                    </el-form-item>
                                                    <el-form-item label="首页链接" prop="homeUrl" class="inLine">
                                                        <el-input v-model="dataForm.homeUrl" :disabled="editable" placeholder="请输入链接" maxlength="18" />
                                                    </el-form-item>
                                                    <el-form-item label="用户昵称" prop="nickName" class="inLine">
                                                        <el-input v-model="dataForm.nickName" :disabled="editable" placeholder="请输入昵称" auto-complete="off" />
                                                    </el-form-item>
                                                    <el-form-item label="QQ" class="inLine">
                                                        <el-input v-model="dataForm.qq" placeholder="请输入QQ" />
                                                    </el-form-item>
                                                    <el-form-item label="微信" class="inLine">
                                                        <el-input v-model="dataForm.wechat" placeholder="请输入微信" />
                                                    </el-form-item>
                                                    <el-form-item label="用户性别" prop="phone" class="inLine" style="width: 293px;">
                                                        <el-select v-model="value" placeholder="未选择" style="width: 100%;">
                                                            <el-option
                                                                v-for="item in options"
                                                                :key="item.value"
                                                                :label="item.label"
                                                                :value="item.value"
                                                            />
                                                        </el-select>
                                                    </el-form-item>
                                                    <el-form-item label="所属公司" prop="homeUrl" class="inLine">
                                                        <el-input v-model="dataForm.company" :disabled="editable" placeholder="请输入公司" maxlength="18" />
                                                    </el-form-item>
                                                </div>
                                            </el-form>
                                        </div>
                                    </el-card>
                                </div>
                                <div>
                                    <el-card class="box-card">
                                        <div>
                                            <el-tooltip content="表内信息从数据库获取,无法直接手动修改" placement="bottom" effect="light">
                                                <el-descriptions title="职位信息" direction="vertical" :column="4" border>
                                                    <el-descriptions-item label="用户名">shellwe</el-descriptions-item>
                                                    <el-descriptions-item label="手机号">17600000000</el-descriptions-item>
                                                    <el-descriptions-item label="职位" :span="2">HR-admin项目负责人</el-descriptions-item>
                                                    <el-descriptions-item label="备注">
                                                        <el-tag size="small">HR-admin项目总负责人 TernaryProjectTeam负责人</el-tag>
                                                    </el-descriptions-item>
                                                    <el-descriptions-item label="联系地址">广东省湛江市霞山区东新街道***</el-descriptions-item>
                                                </el-descriptions>
                                            </el-tooltip>
                                        </div>
                                    </el-card>
                                </div>
                            </el-col>
                        </el-row>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="安全设置" class="security">
                    <h2>安全设置</h2>
                    <div class="setting-list">
                        <div class="item">
                            <div class="content">
                                <div class="title">账户密码</div>
                                <div class="desc">当前密码强度：强</div>
                            </div>
                            <div class="action">
                                <el-button type="text" @click="editPassword">修改</el-button>
                            </div>
                        </div>
                        <div class="item">
                            <div class="content">
                                <div class="title">密保手机</div>
                                <div class="desc">已绑定手机：176****2321</div>
                            </div>
                            <div class="action">
                                <el-button type="text">修改</el-button>
                            </div>
                        </div>
                        <div class="item">
                            <div class="content">
                                <div class="title">备用邮箱</div>
                                <div class="desc">当前未绑定备用邮箱</div>
                            </div>
                            <div class="action">
                                <el-button type="text">绑定</el-button>
                            </div>
                        </div>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="未定设置" />
            </el-tabs>
        </page-main>
        <el-dialog
            title="来自shellwe的警告"
            :visible.sync="dialogVisible"
            width="30%"
        >
            <span>开发中 暂时拒绝提交至后台 数据未更改</span>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
export default {
    name: 'PersonalSetting',
    beforeRouteLeave(to, from, next) {
        if (['personalEditPassword'].includes(to.name)) {
            this.$store.commit('keepAlive/add', 'PersonalSetting')
        }
        next()
    },
    props: {},
    data() {
        return {
            form: {
                headimg: '',
                mobile: '',
                name: '',
                qq: '',
                wechat: ''
            },
            dataForm: {
                realName: 'Benjamin Thomas Shellwe',
                nickName: 'shellwe',
                phone: '176***2321',
                homeUrl: 'http://shellwe.top',
                company: 'TernaryProjectTeam',
                qq: '774****22',
                wechat: '176***2321'
            },
            options: [{
                value: '选项1',
                label: '男'
            }, {
                value: '选项2',
                label: '女'
            }, {
                value: '选项3',
                label: '未设置'
            }],
            value: '',
            dialogVisible: false,
            done: false,
            editable: true
        }
    },
    created() {},
    mounted() {},
    methods: {
        back() {
            history.go(-1)
        },
        handleSuccess(res) {
            if (res.error == '') {
                this.form.headimg = res.data.path
            } else {
                this.$message.warning(res.error)
            }
        },
        editPassword() {
            this.$router.push({
                name: 'personalEditPassword'
            })
        },
        changeEditable(val) {
            if (val == '1') {
                this.done = !this.done
                this.editable = !this.editable
            } else {
                this.dialogVisible = true
                this.done = !this.done
                this.editable = !this.editable
            }
        }
    }
}
</script>

<style lang="scss" scoped>
::v-deep .el-tabs {
    .el-tabs__header .el-tabs__nav {
        .el-tabs__active-bar {
            z-index: 0;
            width: 100%;
            background-color: #e1f0ff;
            border-right: 2px solid #409eff;
        }
        .el-tabs__item {
            text-align: left;
            padding-right: 100px;
        }
    }
    .el-tab-pane {
        padding: 0 20px 0 30px;
    }
}
h2 {
    margin: 0;
    margin-bottom: 30px;
    font-weight: normal;
}
.basic {
    ::v-deep .headimg-upload {
        > div {
            text-align: center;
        }
        .el-upload-dragger {
            border-radius: 50%;
        }
    }
}
.security {
    .setting-list {
        .item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 0;
            border-bottom: 1px solid #e8e8e8;
            .content {
                .title {
                    margin-bottom: 5px;
                    color: #666;
                }
                .desc {
                    font-size: 14px;
                    color: #999;
                }
            }
            &:last-child {
                border-bottom: 0;
            }
        }
    }
}
.inLine {
    display: inline-block;
    clear: both;
}
</style>
