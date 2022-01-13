<template>
    <div>
        <page-header title="个人账户">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为个人账户的基本设置
                </div>
            </template>
        </page-header>
        <page-main>
            <div>
                <el-row :gutter="20" style="margin-top: 10px;">
                    <el-col :span="8">
                        <div class="grid-content bg-purple">
                            <el-card class="box-card">
                                <div slot="header" class="clearfix">
                                    <span>个人中心</span>
                                </div>
                                <div class="name-role">
                                    <span class="sender">Admin - {{ $store.state.user.account }}</span>
                                </div>
                                <div class="register-info">
                                    <span class="register-info">
                                        注册时间：2022/01/13 22:08:33
                                    </span>
                                </div>
                                <el-divider />
                                <div class="personal-relation">
                                    <div class="relation-item">手机号码:  <div style="float: right; padding-right: 20px;">{{ dataForm.phone }}</div></div>
                                </div>
                                <div class="personal-relation">
                                    <div class="relation-item">所属企业:  <div style="float: right; padding-right: 20px;">TernaryProjectTeam</div></div>
                                </div>
                                <div class="personal-relation">
                                    <div class="relation-item">首页链接:  <div style="float: right; padding-right: 20px;">{{ dataForm.homeUrl }}</div></div>
                                </div>
                            </el-card>
                        </div>
                    </el-col>
                    <el-col :span="16">
                        <div class="grid-content bg-purple">
                            <el-card class="box-card">
                                <div slot="header">
                                    <span>基本资料</span>
                                    <el-button v-show="editable" type="primary" size="mini" class="button" @click="changeEditable(1)">编辑</el-button>
                                    <el-button v-show="done" type="success" size="mini" class="button" @click="changeEditable(0)">完成</el-button>
                                </div>
                                <div>
                                    <el-form v-model="dataFrom" label-width="100px" size="small" label-position="right">
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
                                        </div>
                                        <div>
                                            <el-form-item label="用户昵称" prop="nickName" class="inLine">
                                                <el-input v-model="dataForm.nickName" :disabled="editable" placeholder="请输入昵称" auto-complete="off" />
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
                        <div class="grid-content bg-purple">
                            <el-card class="box-card">
                                <div slot="header" class="clearfix">
                                    <span>职位资料</span>
                                </div>
                                <div>
                                    正在部署,请等待开发完毕
                                </div>
                            </el-card>
                        </div>
                    </el-col>
                </el-row>
            </div>
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
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    data() {
        return {
            dataForm: {
                realName: 'Benjamin Thomas Shellwe',
                nickName: 'shellwe',
                phone: '176***2321',
                homeUrl: 'http://shellwe.top',
                company: 'TernaryProjectTeam'
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
    methods: {
        back() {
            history.go(-1)
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
.inLine {
    display: inline-block;
    clear: both;
}
.hover {
    cursor: pointer;
}
//卡片样式
.text {
    font-size: 14px;
}
.item {
    margin-bottom: 18px;
}
.clearfix::before,
.clearfix::after {
    display: table;
    content: "";
}
.clearfix::after {
    clear: both;
    display: inline;
}
.box-card {
    width: 100%;
}
//文本样式区
.name-role {
    font-size: 16px;
    padding: 5px;
    text-align: center;
}
.sender {
    text-align: center;
}
.register-info {
    text-align: center;
    padding-top: 10px;
}
.personal-relation {
    font-size: 16px;
    padding: 0 5px 15px;
    margin-right: 1px;
    width: 100%;
}
.relation-item {
    padding: 12px;
}
.button {
    float: right;
    margin-right: 90px;
}
.button2 {
    float: right;
    margin-right: 10px;
}
//布局样式区
.el-row {
    margin-bottom: 20px;
    &:last-child {
        margin-bottom: 0;
    }
}
.el-col {
    border-radius: 4px;
}
.bg-purple-dark {
    background: #99a9bf;
}
.bg-purple {
    background: #d3dce6;
}
.bg-purple-light {
    background: #e5e9f2;
}
.grid-content {
    border-radius: 4px;
    min-height: 36px;
}
.row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
}
</style>
