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
                <span style="margin-right: 10px;">快捷定位</span>
                <el-button plain @click="handleToPosition('pageOni')">即将空缺职位栏</el-button>
                <el-button plain @click="handleToPosition('pageBin')">已经空缺职位栏</el-button>
                <el-button plain @click="handleToPosition('pageTer')">空缺信息调整栏</el-button>
            </el-row>
        </el-card>
        <page-main id="pageOni" title="空缺职位与离职审批">
            <el-row style="max-height: 337px;">
                <el-col :span="12" style="margin-right: 0;">
                    <el-table
                        :data="pagePropsValueUni"
                        style="width: 720px; margin-right: 10px;"
                        :row-class-name="tableRowClassName"
                        height="337px"
                        @cell-mouse-enter="handleGetDetails"
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
                </el-col>
                <el-col :span="12" style="margin-left: 0;">
                    <el-table
                        :data="pagePropsValueUni"
                        style="width: 720px; margin-left: 30px; max-height: 337px;"
                        height="337px"
                        border
                        @cell-mouse-enter="handleGetDetails"
                    >
                        <el-table-column type="expand" label="展开" width="50px">
                            <template #default="props">
                                <el-form label-position="left" inline>
                                    <el-descriptions class="margin-top" title="离职申请详情" :column="4" :size="size" border>
                                        <template slot="extra">
                                            <el-button type="primary" size="small" style="margin-right: 20px;" @click="pageDialogVisible = true">操作</el-button>
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
                    <el-dialog
                        title="离职审批操作"
                        :visible.sync="pageDialogVisible"
                        width="25%"
                        :before-close="handleClose">
                        <el-row>
                            <el-col>
                                <el-form :model="pageFormUni" label-width="80px">
                                    <el-form-item label="反馈选择">
                                        <el-select v-model="pageFormUni.select" size="mini" style="width: 200px;" placeholder="请选择">
                                            <el-option
                                                v-for="item in pageSelectOptions"
                                                :key="item.value"
                                                :label="item.label"
                                                :value="item.value"
                                                :disabled="item.disabled"
                                            >
                                            </el-option>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="附带说明">
                                        <el-input v-model="pageFormUni.input" :placeholder="pageInputPlaceholder" style="width: 200px;" size="mini" clearable @focus="handlePlaceholder(pageFormUni.select)" />
                                    </el-form-item>
                                </el-form>
                            </el-col>
                        </el-row>
                        <span slot="footer" class="dialog-footer">
                            <el-button @click="pageDialogVisible = false">取 消</el-button>
                            <el-button type="primary" @click="handleButtonConfirm">确 定</el-button>
                        </span>
                    </el-dialog>
                </el-col>
            </el-row>
        </page-main>
        <page-main id="pageBin" title="已经空缺与信息调整">
            <el-row>
                <el-col :span="12">
                    <el-table
                        :data="pagePropsValueBin"
                        style="width: 720px; margin-right: 10px;"
                        :row-class-name="tableRowClassName"
                        height="337px"
                        border
                        @cell-mouse-enter="handleGetDetails"
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
                                            <span>{{ props.row.name }}</span>
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
                </el-col>
                <el-col :span="12">
                    <el-table
                        :data="pagePropsValueBin"
                        style="width: 720px; margin-left: 30px; max-height: 337px;"
                        height="337px"
                        border
                        @cell-mouse-enter="handleGetDetails"
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
                            width="50px"
                        >
                            <template>
                                <el-button type="text" size="small" @click="pageTemplateShow=true">编辑</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-col>
            </el-row>
            <div v-show="pageTemplateShow" style="margin-top: 10px; height: 20px;">
                <el-form ref="form" v-model="pagePropsValueBin" label-width="80px" size="mini">
                    <el-row>
                        <el-col :span="4">
                            <el-form-item label="事务ID">
                                <el-input v-model="pagePropsValueBin.affairID" :placeholder="pagePropsValueBin.affairID" disabled />
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
                                    <el-form-item label="空缺职位部门" prop="department">
                                        <!--                                        <el-select v-model="pageForm.department" placeholder="选择部门" style="width: 150px;" size="mini">-->
                                        <!--                                            <el-option label="人事部门" value="人事部门" />-->
                                        <!--                                            <el-option label="教辅部门" value="education" />-->
                                        <!--                                            <el-option label="软件部门" value="software" />-->
                                        <!--                                        </el-select>-->
                                        <el-select
                                            v-model="pageForm.department"
                                            filterable
                                            allow-create
                                            remote
                                            reserve-keyword
                                            placeholder="查询部门"
                                            :loading="pageLoading"
                                            :remote-method="handleRemoteMethod"
                                            style="width: 150px;"
                                            size="mini"
                                        >
                                            <el-option
                                                v-for="item in options"
                                                :key="item.value"
                                                :label="item.label"
                                                :value="item.value"
                                            />
                                        </el-select>
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
                <el-tab-pane v-auth="'permission.edit'" label="信息调整">
                    <el-alert
                        title="仅拥有高级权限管理员可见与编辑"
                        type="error"
                    />
                    <el-table
                        :data="pagePropsValueUni.filter(data => !search || data.id.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                        border
                        @cell-mouse-enter="handleGetDetails"
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
                        @cell-mouse-enter="handleGetDetails"
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
            pageFormUni: {
                select: '',
                input: ''
            },
            pageInputPlaceholder: '请输入',
            pageRowValue: {},
            pageRemoteValue: [],
            pageSelectOptions: [
                {
                    value: 'agree',
                    label: '同意'
                },
                {
                    value: 'disagree',
                    label: '拒绝'
                },
                {
                    value: 'delay',
                    label: '推迟',
                    disabled: true
                }
            ],
            pageDialogVisible: false,
            pageLoading: false,
            pageDepartmentValue: [],
            pageSelectValue: [],
            pageShow: true,
            pageShowUni: false,
            size: '',
            search: '',
            pageTemplateShow: false,
            publish: false,
            options: [],
            pageDepartment: {
                departmentID: '',
                name: '',
                enterpriseID: '',
                enterprise: '',
                UIDD: '',
                phoneD: '',
                UIDM: '',
                phoneM: '',
                director: '',
                manager: '',
                departmentStatus: ''
            },
            pageForm: {
                position: '',
                department: '',
                createdTime: '',
                deadline: '',
                salary: '',
                type: [],
                requirement: '',
                description: '',
                enterpriseID: ''
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
                departmentID: '部门ID',
                name: '部门名称',
                enterpriseID: '企业标识',
                enterprise: '企业名称',
                UIDD: '主管UID',
                director: '部门主管',
                phoneD: '主管电话',
                UIDM: '经理UID',
                manager: '部门经理',
                phoneM: '经理电话',
                departmentStatus: '部门状态'
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
                    departmentID: '部门ID示例',
                    name: '部门名称示例',
                    enterpriseID: '企业标识示例',
                    enterprise: '企业名称示例',
                    UIDD: '主管UID示例',
                    director: '部门主管示例',
                    phoneD: '主管电话示例',
                    UIDM: '经理UID示例',
                    manager: '部门经理示例',
                    phoneM: '经理电话示例',
                    departmentStatus: '部门状态示例'
                },
                {
                    departmentID: '部门ID示例1',
                    name: '部门名称示例1',
                    enterpriseID: '企业标识示例1',
                    enterprise: '企业名称示例1',
                    UIDD: '主管UID示例1',
                    director: '部门主管示例1',
                    phoneD: '主管电话示例1',
                    UIDM: '经理UID示例1',
                    manager: '部门经理示例1',
                    phoneM: '经理电话示例1',
                    departmentStatus: '部门状态示例1'
                },
                {
                    departmentID: '部门ID示例2',
                    name: '部门名称示例2',
                    enterpriseID: '企业标识示例2',
                    enterprise: '企业名称示例2',
                    UIDD: '主管UID示例2',
                    director: '部门主管示例2',
                    phoneD: '主管电话示例2',
                    UIDM: '经理UID示例2',
                    manager: '部门经理示例2',
                    phoneM: '经理电话示例2',
                    departmentStatus: '部门状态示例2'
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
            // console.log('work!')
        },
        handleToPosition(key) {
            const PageId = document.querySelector('#' + key)
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
                url: '/enterprise/query/uniteTable'
            }).then(function(response) {
                // console.log(response)
                that.pagePropsValueBin = response.data
                // console.log(that.pagePropsValueBin)
            }).catch(function(error) {
                console.log(error)
            })
            axios({
                method: 'post',
                url: '/vacancyComing/queryAll'
            }).then(function(response) {
                that.pagePropsValueUni = response.data.data.filter(
                    item => item.verify == '0'
                )
                // console.log(that.pagePropsValueUni)
            }).catch(function(error) {
                console.log(error)
            })
        },
        // handleGetValue 获取EID进行查询
        handleGetValue() {
            this.handleQueryValue()
            const that = this
            axios({
                method: 'post',
                url: '/user/get/EID',
                data: {
                    id: that.$store.state.user.id
                }
            }).then(response => {
                that.pageForm.enterpriseID = that.enterpriseID
                that.pageDepartment.enterpriseID = that.enterpriseID
                axios({
                    method: 'post',
                    url: '/enterprise/query/department',
                    data: {
                        enterpriseID: response.data.data[0].enterpriseID
                    }
                }).then(function(response) {
                    // console.log(response)
                    let t = {}
                    let u = []
                    response.data.data.forEach(function(item) {
                        for (let key in item) {
                            if (key == 'name') {
                                t[key] = item[key]
                            }
                        }
                        u.push(t)
                        t = {}
                        for (let key in u) {
                            if (u[key].name !== '' && u[key].name !== null) {
                                // console.log(u[key].name)
                                that.pageRemoteValue.push(u[key].name)
                                that.pageRemoteValue = that.pageRemoteValue.sort()
                                let array = [that.pageRemoteValue[0]]
                                for (let i = 1; i < that.pageRemoteValue.length; i++) {
                                    if (that.pageRemoteValue[i] !== that.pageRemoteValue[i - 1]) {
                                        array.push(that.pageRemoteValue[i])
                                    }
                                }
                                that.pageRemoteValue = array
                            }
                        }
                        // console.log(that.pageRemoteValue)
                        t = {}
                        that.list = that.pageRemoteValue.map(item => {
                            return {value: `${item}`, label: `${item}`}
                        })
                    })
                })
            }).catch(error => {
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
        },
        handleClose() {
            this.$confirm('确认关闭？输入信息将不会保存')
                .then(() => {
                    this.pageDialogVisible = false
                })
        },
        handlePlaceholder(val) {
            if (val == 'agree') {
                this.pageInputPlaceholder = '同意申请也得准备相关材料'
            }
            if (val == 'disagree') {
                this.pageInputPlaceholder = '拒绝申请也得给出恰当理由'
            }
        },
        handleGetDetails(row) {
            this.pageRowValue = row
            // console.log(this.pageRowValue)
        },
        handleButtonConfirm() {
            // const that = this
            if (this.pageFormUni.select == 'agree') {
                axios({
                    method: 'post',
                    url: '/vacancyComing/updateById',
                    data: {
                        affairID: this.pageRowValue.affairID,
                        verify: 1
                    }
                }).then(response => {
                    this.$notify({
                        title: response.data.msg,
                        type: 'success'
                    })
                    this.pageRowValue.verify = 1
                }).catch(error => {
                    console.log(error)
                })
            }
            if (this.pageFormUni.select == 'disagree') {
                axios({
                    method: 'post',
                    url: '/vacancyComing/updateById',
                    data: {
                        affairID: this.pageRowValue.affairID,
                        verify: 2
                    }
                }).then(response => {
                    this.$notify({
                        title: response.data.msg,
                        type: 'success'
                    })
                    this.pageRowValue.verify = 2
                }).catch(error => {
                    console.log(error)
                })
            }
            this.pageDialogVisible = false
            this.handleQueryValue()
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
