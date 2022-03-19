<template>
    <div>
        <page-header title="员工背景调查">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置背景调查</div>
                </div>
            </template>
        </page-header>
        <el-alert
            title="背景调查主要调查:基本信息、调查工作履历和履职表现，并非深入调查个人信息的功能。"
            type="warning"
        />
        <page-main title="背景调查">
            <el-card shadow="hover" style="margin-bottom: 5px;">
                <el-form ref="pageRuleForm" :model="pageRuleForm" status-icon :rules="pageRules">
                    <el-row>
                        <el-col :span="4">
                            <el-form-item label="账户ID" prop="ID">
                                <el-input v-model="pageRuleForm.ID" autocomplete="off" class="pageInputCSS" />
                            </el-form-item>
                        </el-col>
                        <el-col :span="4">
                            <el-form-item label="员工姓名" prop="userName">
                                <el-input v-model="pageRuleForm.userName" type="text" autocomplete="off" class="pageInputCSS" />
                            </el-form-item>
                        </el-col>
                        <el-col :span="4">
                            <el-form-item label="所属部门" prop="department">
                                <el-input v-model.number="pageRuleForm.department" class="pageInputCSS" />
                            </el-form-item>
                        </el-col>
                        <el-col :span="4">
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('pageRuleForm')">提交</el-button>
                                <el-button @click="resetForm('pageRuleForm')">重置</el-button>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
            </el-card>
        </page-main>
        <page-main title="查询结果">
            <el-row>
                <el-col :span="8">
                    <el-table
                        :data="tableData"
                        style="width: 100%;"
                        border
                    >
                        <el-table-column type="expand">
                            <template #default="props">
                                <el-form label-position="left" inline class="demo-table-expand">
                                    <el-descriptions class="margin-top" title="详情列表" :column="2" size="mini" border>
                                        <template slot="extra">
                                            <el-button type="primary" size="small" style="margin-right: 20px;" @click="handleConfirmButton">表格→</el-button>
                                        </template>
                                        <el-descriptions-item
                                            v-for="(col, key) in cols" :key="key"
                                            :label="col.prop"
                                            style="width: 50%;"
                                        >
                                            <span>
                                                {{ props.row[col.label] }}
                                            </span>
                                        </el-descriptions-item>
                                    </el-descriptions>
                                </el-form>
                            </template>
                        </el-table-column>
                        <el-table-column
                            label="账户 ID"
                            prop="id">
                        </el-table-column>
                        <el-table-column
                            label="真实姓名"
                            prop="name">
                        </el-table-column>
                    </el-table>
                </el-col>
                <el-col v-show="pageColVisible" style="margin-left: 20px;" :span="14">
                    <el-card>未选择数据</el-card>
                </el-col>
                <el-col v-show="pageColVisibleUni" :span="16">
                    <el-card style="margin-left: 20px; margin-right: 10px;" shadow="hover">
                        <el-row>
                            <el-col :span="5">
                                <el-image
                                    style="width: 105px; height: 135px; margin-left: 30px;"
                                    :src="url"
                                    :preview-src-list="srcList">
                                </el-image>
                            </el-col>
                            <el-col :span="18">
                                <el-descriptions title="基本信息" border>
                                    <el-descriptions-item label="用户名">shellwe</el-descriptions-item>
                                    <el-descriptions-item label="手机号">18100000000</el-descriptions-item>
                                    <el-descriptions-item label="居住地">广州市</el-descriptions-item>
                                    <el-descriptions-item label="备注">
                                        <el-tag size="small">项目负责人</el-tag>
                                    </el-descriptions-item>
                                    <el-descriptions-item label="用户状况">在职</el-descriptions-item>
                                    <el-descriptions-item label="背调情况">已提取</el-descriptions-item>
                                </el-descriptions>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-descriptions title="详细信息" border style="margin-left: 30px;" :column="1">
                                <el-descriptions-item label="个人履历">null</el-descriptions-item>
                                <el-descriptions-item label="曾经担任">null</el-descriptions-item>
                                <el-descriptions-item label="最高学历">null</el-descriptions-item>
                                <el-descriptions-item label="其余备注">
                                    <el-tag size="small">sponsor</el-tag>
                                </el-descriptions-item>
                                <el-descriptions-item label="联系地址">广东省广州市从化区广从南路 548 号</el-descriptions-item>
                            </el-descriptions>
                        </el-row>

                    </el-card>
                </el-col>
            </el-row>
        </page-main>
    </div>
</template>

<script>

export default {
    name: 'Background',
    data() {
        var checkDepartment = (rule, value, callback) => {
            if (!value) {
                if (this.pageRuleForm.ID == '') {
                    callback(new Error('若不使用账户ID查询, \n 部门选项不能为空'))
                } else {
                    callback()
                }
            }
        }
        let validateID = (rule, value, callback) => {
            if (value === '') {
                if (this.pageRuleForm.userName === '' && this.pageRuleForm.department === '') {
                    callback(new Error('请输入账户ID进行查询'))
                } else {
                    callback()
                }
            }
            setTimeout(() => {
                if (isNaN(value)) {
                    callback(new Error('请输入数字值'))
                } else {
                    if (value.length !== 10) {
                        callback(new Error('ID长度不正确'))
                    } else {
                        callback()
                    }
                }
            }, 1000)
        }
        var validateName = (rule, value, callback) => {
            if (value === '') {
                if (this.pageRuleForm.ID == '') {
                    callback(new Error('若不使用账户ID查询, \n 姓名选项不能为空'))
                }
            }
            setTimeout(() => {
                if (value.length > 6) {
                    callback(new Error('员工姓名长度不正确'))
                } else {
                    callback()
                }
            }, 1000)
        }
        return {
            search: '',
            url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
            srcList: [
                'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
                'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
            ],
            pageColVisible: true,
            pageColVisibleUni: false,
            pageRuleForm: {
                ID: '',
                userName: '',
                department: ''
            },
            pageRules: {
                ID: [
                    { validator: validateID, trigger: 'blur' }
                ],
                userName: [
                    { validator: validateName, trigger: 'blur' }
                ],
                department: [
                    { validator: checkDepartment, trigger: 'blur' }
                ]
            },
            cols: [
                {label: 'id', prop: '账户 ID'},
                {label: 'salary', prop: '工资情况'},
                {label: 'position', prop: '所属职位'},
                {label: 'department', prop: '归属部门'}
            ],
            tableData:
                [
                    {
                        id: '202102101712',
                        salary: '7k',
                        position: '主管',
                        department: '人事',
                        name: 'Oscar'
                    },
                    {
                        id: '202102101713',
                        salary: '1.2w',
                        position: '经理',
                        department: '软件',
                        name: 'Fay'
                    },
                    {
                        id: '202102101714',
                        salary: '4k',
                        position: '教辅员',
                        department: '教辅',
                        name: 'Arlen'
                    },
                    {
                        id: '201605031416',
                        salary: '2w',
                        position: '总负责',
                        department: '总部',
                        name: 'Aimee'
                    }
                ]
        }
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleConfirmButton() {
            this.pageColVisible = false
            this.pageColVisibleUni = true
        },
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    alert('submit!')
                } else {
                    console.log('error submit!!')
                    return false
                }
            })
        },
        resetForm(formName) {
            this.$refs[formName].resetFields()
        }
    }
}
</script>
<style>
.pageInputCSS {
    width: 150px;
    margin-right: 5px;
}
.el-descriptions-item label {
    width: 80px;
}
</style>
