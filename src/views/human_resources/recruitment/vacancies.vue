<template>
    <div>
        <page-header title="职位空缺管理">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置控制企业将空缺或已空缺的职位</div>
                    <div>{{ $store.state.settings.permissions }}</div>
                </div>
            </template>
        </page-header>
        <el-card style="margin-left: 20px; margin-right: 20px;">
            <el-row>
                <span>快捷定位按钮&nbsp;&nbsp;</span>
                <el-button plain @click="handleToPosition('Oni')">即将空缺职位栏</el-button>
                <el-button plain @click="handleToPosition('Bin')">已经空缺职位栏</el-button>
                <el-button plain @click="handleToPosition('Ter')">空缺信息调整栏</el-button>
            </el-row>
        </el-card>
        <page-main id="pageOni" title="即将空缺职位">
            <el-table
                :data="pagePropsValueUni"
                style="width: 100%;"
                :row-class-name="tableRowClassName"
            >
                <el-table-column
                    prop="affairID"
                    label="事务ID"
                />
                <el-table-column
                    prop="position"
                    label="即将空缺"
                />
                <el-table-column
                    prop="department"
                    label="所属部门"
                />
                <el-table-column
                    prop="estimatedTime"
                    label="截止时间"
                />
            </el-table>
        </page-main>
        <page-main id="pageBin" title="已经空缺职位">
            <el-table
                :data="pagePropsValueBin"
                style="width: 100%;"
                :row-class-name="tableRowClassName"
                border
            >
                <el-table-column type="expand" label="展开" width="50px">
                    <template #default="props">
                        <el-form label-position="left" inline>
                            <el-descriptions class="margin-top" title="职位空缺详情" :column="4" :size="size" border>
                                <!--                                <template slot="extra">-->
                                <!--                                    <el-button type="primary" size="small" style="margin-right: 20px;">操作</el-button>-->
                                <!--                                </template>-->
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="application" />
                                        申请事件 ID
                                    </template>
                                    <span>{{ props.row.affairID }}</span>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="position" />
                                        空缺职位
                                    </template>
                                    <el-tag size="small"><span>{{ props.row.position }}</span></el-tag>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="state" />
                                        职位状态
                                    </template>
                                    <el-tag size="small"><span>{{ props.row.positionStatus }}</span></el-tag>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="department" />
                                        所属部门
                                    </template>
                                    <span>{{ props.row.department }}</span>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="director" />
                                        部门主管
                                    </template>
                                    <span>{{ props.row.director }}</span>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <i class="el-icon-mobile-phone" />
                                        手机号码
                                    </template>
                                    <span>{{ props.row.phoneD }}</span>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="manager" />
                                        部门经理
                                    </template>
                                    <span>{{ props.row.manager }}</span>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <i class="el-icon-mobile-phone" />
                                        手机号码
                                    </template>
                                    <span>{{ props.row.phoneM }}</span>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="state" />
                                        部门状态
                                    </template>
                                    <span>{{ props.row.departmentStatus }}</span>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="description" />
                                        基本描述
                                    </template>
                                    <span>{{ props.row.description }}</span>
                                </el-descriptions-item>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="applyTime" />
                                        创建时间
                                    </template>
                                    <span>{{ props.row.createdTime }}</span>
                                </el-descriptions-item>
                                <br>
                            </el-descriptions>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column
                    label="申请事务 ID"
                    prop="affairID"
                />
                <el-table-column
                    label="空缺职位"
                    prop="position"
                />
                <el-table-column
                    label="职位状态"
                    prop="positionStatus"
                />
                <el-table-column
                    label="部门状态"
                    prop="departmentStatus"
                />
            </el-table>
        </page-main>
        <page-main id="pageTer" title="空缺信息调整">
            <el-tabs tab-position="left">
                <el-tab-pane label="空缺发布">
                    <el-form ref="pageForm" :model="pageForm" :rules="rules" label-width="120px" label-position="right">
                        <div>
                            <el-row>
                                <el-col :span="6">
                                    <el-form-item label="空缺职位名称" prop="position">
                                        <el-input v-model="pageForm.position" style="width: 150px;" size="mini" />
                                    </el-form-item>
                                </el-col>
                                <el-col :span="6">
                                    <el-form-item label="空缺职位部门" prop="position">
                                        <el-select v-model="pageForm.department" placeholder="选择部门" style="width: 150px;" size="mini">
                                            <el-option label="人事部门" value="人事部门" />
                                            <el-option label="教辅部门" value="education" />
                                            <el-option label="软件部门" value="software" />
                                        </el-select>
                                        <el-form-item label="员工账户" prop="account" label-width="120px">
                                            <el-select
                                                v-model="pageSelectValue"
                                                filterable
                                                allow-create
                                                remote
                                                reserve-keyword
                                                placeholder="可查询,可新建(不可重复)"
                                                :remote-method="handleRemoteMethod"
                                                :loading="pageLoading"
                                                style="width: 190px;"
                                                size="small"
                                            >
                                                <el-option
                                                    v-for="item in options"
                                                    :key="item.value"
                                                    :label="item.label"
                                                    :value="item.value"
                                                />
                                            </el-select>
                                        </el-form-item>
                                    </el-form-item>
                                </el-col>
                                <el-col :span="6">
                                    <el-form-item label="空缺职位状态" prop="positionStatus">
                                        <el-input v-model="pageForm.positionStatus" style="width: 150px;" size="mini" />
                                    </el-form-item>
                                </el-col>
                                <el-col :span="6">
                                    <el-form-item label="空缺职位薪资" prop="salary">
                                        <el-input v-model="pageForm.salary" style="width: 150px;" size="mini" />
                                    </el-form-item>
                                </el-col>
                            </el-row>
                            <el-row>
                                <el-col :span="6">
                                    <el-form-item label="空缺职位要求" prop="requirement">
                                        <el-input v-model="pageForm.requirement" style="width: 150px;" size="mini" />
                                    </el-form-item>
                                </el-col>
                                <el-col :span="6">
                                    <el-form-item label="空缺预设发布" prop="date">
                                        <el-tooltip class="item" effect="dark" content="立即发布" placement="top">
                                            <el-switch v-model="publish" style="width: 20px;" @change="handlePropChange" />
                                        </el-tooltip>
                                        <el-date-picker v-show="pageShow" v-model="pageForm.createdTime" :disabled.sync="publish" type="datetime" placeholder="选择日期" style="margin-left: 5px; width: 175px;" size="mini" />
                                        <span v-show="pageShowUni">  立 即 发 布!!</span>
                                    </el-form-item>
                                </el-col>
                                <el-col :span="6">
                                    <el-form-item label="发布截止时间" prop="date">
                                        <el-date-picker v-model="pageForm.deadline" type="datetime" placeholder="选择日期" style="width: 175px;" size="mini" />
                                    </el-form-item>
                                </el-col>
                            </el-row>
                            <el-form-item label="招聘性质" prop="type">
                                <el-checkbox-group v-model="pageForm.type">
                                    <el-checkbox label="线上招聘" value="online" />
                                    <el-checkbox label="线下招聘" value="offline" />
                                    <el-checkbox label="内推招聘" value="internal" />
                                    <el-checkbox label="第三方商" value="third" />
                                </el-checkbox-group>
                            </el-form-item>
                            <el-form-item label="附加说明">
                                <el-input v-model="pageForm.description" type="textarea" />
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="onSubmit('pageForm')">发布</el-button>
                                <el-button @click="resetForm('pageForm')">重置</el-button>
                            </el-form-item>
                        </div>
                    </el-form>
                </el-tab-pane>
                <el-tab-pane label="离职审批">
                    <el-table
                        :data="pagePropsValueUni"
                        style="width: 100%;"
                        border
                    >
                        <el-table-column type="expand" label="展开" width="50px">
                            <template #default="props">
                                <el-form label-position="left" inline>
                                    <el-descriptions class="margin-top" title="离职申请详情" :column="4" :size="size" border>
                                        <template slot="extra">
                                            <el-button type="primary" size="small" style="margin-right: 20px;">操作</el-button>
                                        </template>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <i class="el-icon-user" />
                                                真实姓名
                                            </template>
                                            <span>{{ props.row.name }}</span>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <svg-icon name="gender" />
                                                员工性别
                                            </template>
                                            <span>{{ props.row.sex }}</span>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <svg-icon name="application" />
                                                申请事件 ID
                                            </template>
                                            <span>{{ props.row.affairID }}</span>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <i class="el-icon-mobile-phone" />
                                                手机号码
                                            </template>
                                            <span>{{ props.row.phone }}</span>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <i class="el-icon-office-building" />
                                                联系地址
                                            </template>
                                            <span>{{ props.row.address }}</span>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <svg-icon name="department" />
                                                所属部门
                                            </template>
                                            <span>{{ props.row.department }}</span>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <svg-icon name="position" />
                                                所在职位
                                            </template>
                                            <el-tag size="small"><span>{{ props.row.position }}</span></el-tag>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <svg-icon name="description" />
                                                基本描述
                                            </template>
                                            <span>{{ props.row.description }}</span>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <svg-icon name="applyTime" />
                                                申请时间
                                            </template>
                                            <span>{{ props.row.createdTime }}</span>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <svg-icon name="resign" />
                                                预计离职
                                            </template>
                                            <span>{{ props.row.estimatedTime }}</span>
                                        </el-descriptions-item>
                                        <br>
                                    </el-descriptions>
                                </el-form>
                            </template>
                        </el-table-column>
                        <el-table-column
                            label="申请事务 ID"
                            prop="affairID"
                        />
                        <el-table-column
                            label="员工名称"
                            prop="name"
                        />
                        <el-table-column
                            label="所在职位"
                            prop="position"
                        />
                        <el-table-column
                            label="基本描述"
                            prop="description"
                        />
                    </el-table>
                </el-tab-pane>
                <el-tab-pane label="状态调整">
                    <el-table
                        :data="pagePropsValueBin"
                        border
                        height="235"
                        style="width: 100%;"
                    >
                        <el-table-column
                            fixed
                            prop="affairID"
                            label="事务ID"
                        />
                        <el-table-column
                            prop="position"
                            label="职位名称"
                        />
                        <el-table-column
                            prop="positionStatus"
                            label="职位状态"
                        />
                        <el-table-column
                            prop="department"
                            label="归属部门"
                        />
                        <el-table-column
                            prop="departmentStatus"
                            label="部门状态"
                        />
                        <el-table-column
                            prop="createdTime"
                            label="创建时间"
                        />
                        <el-table-column
                            fixed="right"
                            label="操作"
                            width="100"
                        >
                            <template>
                                <el-button type="text" size="small">查看</el-button>
                                <el-button type="text" size="small" @click="pageTemplateShow=true">编辑</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
                <div v-show="pageTemplateShow" style="margin-top: 10px;">
                    <el-form ref="form" v-model="pagePropsValueBin" label-width="80px" size="mini">
                        <el-row>
                            <el-col :span="4">
                                <el-form-item label="事务ID">
                                    <el-input v-model="pagePropsValueBin.affairID" :placeholder="pagePropsValueBin.id" disabled />
                                </el-form-item>
                            </el-col>
                            <el-col :span="4">
                                <el-form-item label="职位名称">
                                    <el-input v-model="pagePropsValueBin.position" :placeholder="pagePropsValueBin.position" disabled />
                                </el-form-item>
                            </el-col>
                            <el-col :span="4">
                                <el-form-item label="职位状态">
                                    <el-input v-model="pagePropsValueBin.positionStatus" :placeholder="pagePropsValueBin.positionStatus" />
                                </el-form-item>
                            </el-col>
                            <el-col :span="4">
                                <el-form-item label="归属部门">
                                    <el-input v-model="pagePropsValueBin.department" :placeholder="pagePropsValueBin.department" disabled />
                                </el-form-item>
                            </el-col>
                            <el-col :span="4">
                                <el-form-item label="部门状态">
                                    <el-input v-model="pagePropsValueBin.departmentStatus" :placeholder="pagePropsValueBin.departmentStatus" />
                                </el-form-item>
                            </el-col>
                            <el-col :span="4">
                                <el-form-item size="mini">
                                    <el-button type="primary" @click="pageTemplateShow=false">修改</el-button>
                                    <el-button>取消</el-button>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-form>
                </div>
                <el-tab-pane v-auth="'permission.edit'" label="信息调整">
                    <el-alert
                        title="仅拥有高级权限管理员可见与编辑"
                        type="error"
                    />
                    <el-table
                        :data="pagePropsValueUni.filter(data => !search || data.id.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                        border
                    >
                        <el-table-column
                            v-for="(item, index) in pageTableHeaderUni"
                            :key="index"
                            :prop="index"
                            :label="item"
                            :fit="true"
                            sortable
                            min-width="30px"
                        />
                        <el-table-column
                            align="right"
                            fixed="right"
                            width="160px"
                        >
                            <template slot="header">
                                <input
                                    v-model="search"
                                    size="mini"
                                    placeholder="输入事务ID搜索"
                                    style="width: 135px;"
                                >
                            </template>
                            <template slot-scope="scope">
                                <el-button
                                    size="mini"
                                    @click="handleEdit(scope.$index, scope.row)"
                                >
                                    Edit
                                </el-button>
                                <el-button
                                    size="mini"
                                    type="danger"
                                    @click="handleDelete(scope.$index, scope.row)"
                                >
                                    Delete
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <br>
                    <el-alert
                        title="仅拥有高级权限管理员可见与编辑"
                        type="error"
                    />
                    <el-table
                        :data="pagePropsValueBin.filter(data => !search || data.id.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                        border
                    >
                        <el-table-column
                            v-for="(item, index) in pageTableHeaderBin"
                            :key="index"
                            :prop="index"
                            :label="item"
                            :fit="true"
                            sortable
                            min-width="30px"
                        />
                        <el-table-column
                            align="right"
                            fixed="right"
                            width="160px"
                        >
                            <template slot="header">
                                <input
                                    v-model="search"
                                    size="mini"
                                    placeholder="输入事务ID搜索"
                                    style="width: 135px;"
                                >
                            </template>
                            <template slot-scope="scope">
                                <el-button
                                    size="mini"
                                    @click="handleEdit(scope.$index, scope.row)"
                                >
                                    Edit
                                </el-button>
                                <el-button
                                    size="mini"
                                    type="danger"
                                    @click="handleDelete(scope.$index, scope.row)"
                                >
                                    Delete
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
            </el-tabs>
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
import axios from 'axios'

export default {
    name: 'Vacancies',
    components: {PageMain},
    data() {
        return {
            pageLoading: false,
            pageSelectValue: [],
            pageShow: true,
            pageShowUni: false,
            size: '',
            search: '',
            pageTemplateShow: false,
            publish: false,
            options: [],
            pageForm: {
                position: '',
                department: '',
                createdTime: '',
                deadline: '',
                salary: '',
                type: [],
                requirement: '',
                description: ''
            },
            rules: {
                position: [
                    { required: true, message: '请输入职位名称', trigger: 'blur' },
                    { min: 3, max: 25, message: '长度在 3 到 25 个字符', trigger: 'blur' }
                ],
                department: [
                    { required: true, message: '请选择一个部门', trigger: 'change' }
                ],
                createdTime: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                deadline: [
                    { type: 'date', required: true, message: '请选择截止日期', trigger: 'change' }
                ],
                publish: [
                    { type: 'array', required: true, message: '请选择发布时间性质', trigger: 'change' }
                ],
                delivery: [
                    { type: 'array', required: false, message: '暂无', trigger: 'change' }
                ],
                type: [
                    { type: 'array', required: true, message: '请选择招聘性质', trigger: 'change' }
                ],
                resource: [
                    { required: false, message: '暂无', trigger: 'change' }
                ],
                desc: [
                    { required: false, message: '暂无', trigger: 'change' }
                ],
                null: [
                    { required: false }
                ]
            },
            pageTableHeaderUni: {
                affairID: '事务ID',
                name: '账户姓名',
                sex: '用户性别',
                phone: '电话号码',
                address: '记录地址',
                department: '所属部门',
                position: '所属职位',
                description: '基本描述',
                createdTime: '创建时间',
                estimatedTime: '到期时间'
            },
            pageTableHeaderBin: {
                affairID: '事务ID',
                position: '空缺职位',
                positionStatus: '职位状态',
                department: '所属部门',
                director: '部门主管',
                phoneD: '主管电话',
                manager: '部门经理',
                phoneM: '经理电话',
                departmentStatus: '部门状态',
                description: '基本描述',
                createdTime: '创建时间',
                estimatedTime: '到期时间'
            },
            pagePropsValueUni: [
                {
                    affairID: '202202081942',
                    name: 'Sebastian',
                    sex: '男',
                    phone: '12300000000',
                    address: '法兰西普罗旺斯',
                    department: '教辅部门',
                    position: '声乐/乐器教辅导师',
                    description: '准备离职',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    affairID: '202202081943',
                    name: 'Jack',
                    sex: '男',
                    phone: '12300000000',
                    address: '法兰西普罗旺斯',
                    department: '软件部门',
                    position: '测试工程师',
                    description: '准备离职',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    affairID: '202202081944',
                    name: 'Rose',
                    sex: '女',
                    phone: '12300000000',
                    address: '法兰西普罗旺斯',
                    department: '人事部门',
                    position: '人事主管',
                    description: '准备离职',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                }
            ],
            pagePropsValueBin: [
                {
                    affairID: '202202081945',
                    position: '开发工程师',
                    positionStatus: '目前空缺',
                    department: '软件部门',
                    director: 'Steven',
                    phoneD: '17600000000',
                    manager: 'shellwe',
                    phoneM: '17600000000',
                    departmentStatus: 'sufficiency(已达部门标准人数)',
                    description: '梅赛德斯',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    affairID: '202202081946',
                    position: '辅导员',
                    positionStatus: '正在招聘',
                    department: '教辅部门',
                    director: 'Seven',
                    phoneD: '17600000000',
                    manager: 'shellwe',
                    phoneM: '17600000000',
                    departmentStatus: 'insufficiency(未达部门标准人数)',
                    description: '慕尼黑',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    affairID: '202202081947',
                    position: '人事主管',
                    positionStatus: '暂停招聘',
                    department: '人事部门',
                    director: 'Seven',
                    phoneD: '17600000000',
                    manager: 'shellwe',
                    phoneM: '17600000000',
                    departmentStatus: 'overstaffed(已超部门最大人数)',
                    description: '柏林',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                }
            ]
        }
    },
    mounted() {
        this.handleQueryValue()
        this.handleGetValue()
    },
    methods: {
        back() {
            history.go(-1)
        },
        onSubmit(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    axios({
                        method: 'post',
                        url: '/vacancy/addNewVacancy',
                        data: this.pageForm
                    }).then(function(response) {
                        console.log(response)
                    }).catch(function(error) {
                        console.log(error)
                    })
                    alert('submit!')
                } else {
                    console.log('error submit!!')
                    return false
                }
            })
        },
        resetForm(formName) {
            this.$refs[formName].resetFields()
        },
        handlePropChange() {
            if (this.publish) {
                this.pageShow = false
                this.pageShowUni = true
                this.pageForm.date = 'publish now'
                this.rules.date = [
                    { required: false, trigger: 'change' }
                ]
            } else {
                this.pageShow = true
                this.pageShowUni = false
            }
            console.log('work!')
        },
        handleToPosition(key) {
            const PageId = document.querySelector('#page' + key)
            window.scrollTo({
                'top': PageId.offsetTop,
                'behavior': 'smooth'
            })
        },
        handleEdit(index, row) {
            console.log(index, row)
        },
        handleDelete(index, row) {
            console.log(index, row)
        },
        tableRowClassName({row}) {
            if (row.department === '教辅部门') {
                return 'education-row'
            } else if (row.department === '软件部门') {
                return 'software-row'
            } else if (row.department === '人事部门') {
                return 'humanResources-row'
            }
            return ''
        },
        handleQueryValue() {
            const that = this
            axios({
                method: 'post',
                url: '/vacancy/queryAll'
            }).then(function(response) {
                // console.log(response)
                that.pagePropsValueBin = response.data.data

            }).catch(function(error) {
                console.log(error)
            })
            axios({
                method: 'post',
                url: '/vacancyComing/queryAll'
            }).then(function(response) {
                // console.log(response)
                that.pagePropsValueUni = response.data.data
            }).catch(function(error) {
                console.log(error)
            })
        },
        handleGetValue() {
            const that = this
            axios({
                method: 'post',
                url: '/user/query/EID',
                data: {
                    enterpriseID: 0
                }
            }).then(function(response) {
                // console.log(response)
                let t = {}
                let u = []
                response.data.data.forEach(function(item) {
                    for (let key in item) {
                        if (key == 'id') {
                            t[key] = item[key]
                        }
                    }
                    u.push(t)
                    t = {}
                    for (let key in u) {
                        if (u[key].id !== '' && u[key].id !== null) {
                            // console.log(u[key].id)
                            that.pageRemoteValue.push(u[key].id)
                            that.pageRemoteValue = that.pageRemoteValue.sort()
                            var arrry = [that.pageRemoteValue[0]]
                            for (var i = 1; i < that.pageRemoteValue.length; i++) {
                                if (that.pageRemoteValue[i] !== that.pageRemoteValue[i - 1]) {
                                    arrry.push(that.pageRemoteValue[i])
                                }
                            }
                            that.pageRemoteValue = arrry
                        }
                    }
                    t = {}
                    // console.log(that.pageRemoteValue)
                    // that.pageRemoteValue = u
                    // console.log(that.pageRemoteValue)
                    that.list = that.pageRemoteValue.map(item => {
                        return {value: `${item}`, label: `${item}`}
                    })
                    // console.log(that.pageRemoteValue.map)
                    // console.log(that.list)
                })
            }).catch(function(error) {
                console.log(error)
            })
        },
        handleRemoteMethod(query) {
            if (query !== '') {
                this.pageLoading = true
                setTimeout(() => {
                    this.pageLoading = false
                    this.options = this.list.filter(item => {
                        return item.label.toLowerCase().indexOf(query.toLowerCase()) > -1
                    })
                }, 1000)
                // console.log(this.list)
                // console.log(this.options)
            } else {
                this.options = []
            }
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.el-descriptions__title {
    margin-left: 30px;
}
.el-descriptions__header {
    margin-bottom: 13px;
}
.el-table .education-row {
    background: #fdffd0;
}
.el-table .software-row {
    background: #c3d0ff;
}
.el-table .humanResources-row {
    background: #ccffc5;
}
</style>
