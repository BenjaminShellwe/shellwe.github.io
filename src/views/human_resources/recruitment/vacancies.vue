<template>
    <div>
        <page-header title="职位空缺管理">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置控制企业将空缺或已空缺的职位</div>
                </div>
            </template>
        </page-header>
        <page-main title="即将空缺职位">
            <el-table
                :data="pagePropsValueOni"
                style="width: 100%;"
                border>
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
                                    <span>{{ props.row.id }}</span>
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
                    prop="id"
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
        </page-main>
        <page-main title="已经空缺职位">
            <el-table
                :data="pagePropsValueBin"
                style="width: 100%;"
                border>
                <el-table-column type="expand" label="展开" width="50px">
                    <template #default="props">
                        <el-form label-position="left" inline>
                            <el-descriptions class="margin-top" title="职位空缺详情" :column="4" :size="size" border>
                                <template slot="extra">
                                    <el-button type="primary" size="small" style="margin-right: 20px;">操作</el-button>
                                </template>
                                <el-descriptions-item>
                                    <template slot="label">
                                        <svg-icon name="application" />
                                        申请事件 ID
                                    </template>
                                    <span>{{ props.row.id }}</span>
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
                    prop="id"
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
        <page-main title="空缺信息调整">
            <el-card>离职审批;部门,职位状态调整;空缺职位信息调整;职位发布</el-card>
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
export default {
    name: 'Vacancies',
    components: {PageMain},
    data() {
        return {
            size: '',
            pagePropsValueOni: [
                {
                    id: '202202081942',
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
                    id: '202202081943',
                    name: 'Sebastian1',
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
                    id: '202202081944',
                    name: 'Sebastian2',
                    sex: '男',
                    phone: '12300000000',
                    address: '法兰西普罗旺斯',
                    department: '教辅部门',
                    position: '声乐/乐器教辅导师',
                    description: '准备离职',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                }
            ],
            pagePropsValueBin: [
                {
                    id: '202202081945',
                    position: '开发工程师',
                    positionStatus: '目前空缺',
                    department: '软件部门',
                    director: 'Steven',
                    phoneD: '17600000000',
                    manager: 'shellwe',
                    phoneM: '17600000000',
                    departmentStatus: 'full(已达部门标准人数)',
                    description: '梅赛德斯',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    id: '202202081946',
                    position: '辅导员',
                    positionStatus: '正在招聘',
                    department: '辅导部门',
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
                    id: '202202081947',
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
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>
<style>
.el-descriptions__title {
    margin-left: 30px;
}
.el-descriptions__header {
    margin-bottom: 13px;
}
</style>
