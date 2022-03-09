<template>
    <div>
        <page-header title="简历筛选及录用">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面管理企业简历筛选及录用</div>
                </div>
            </template>
        </page-header>
        <page-main title="简历投递表">
            <el-table
                :data="pagePropsValueUni.filter(data => !search || data.id.toLowerCase().includes(search.toLowerCase()))"
                style="width: 100%;"
                max-height="370"
                border
            >
                <el-table-column
                    v-for="(item, key) in pageTableHeaderUni"
                    :key="key"
                    :prop="key"
                    :label="item"
                    :fit="true"
                    min-width="70px"
                />
                <el-table-column
                    align="right"
                >
                    <template slot="header">
                        <input
                            v-model="search"
                            size="mini"
                            placeholder="输入事务ID搜索"
                            style="width: 100px;"
                        >
                    </template>
                    <template slot-scope="scope">
                        <el-button
                            size="mini"
                            style="width: 50px; margin-right: 5px;"
                            @click="handleEdit(scope.$index, scope.row), pageDialogVisible = true"
                        >
                            详情
                        </el-button>
                        <el-dropdown
                            style="width: 50px; margin-left: 5px;"
                            size="mini"
                        >
                            <el-button
                                size="mini"
                                type="success"
                                @click="handleDelete(scope.$index, scope.row)"
                            >
                                操作
                            </el-button>
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item>转交</el-dropdown-item>
                                <el-dropdown-item>录用</el-dropdown-item>
                                <el-dropdown-item>退回</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </template>
                </el-table-column>
            </el-table>
        </page-main>
        <el-dialog
            title="简历详情"
            :visible.sync="pageDialogVisible"
            width="60%"
            left
        >
            <el-row>
                <el-col :span="12">
                    <span class="pageFontTitle">BenjaminThomasShellwe</span>
                </el-col>
                <el-col :span="12">
                    <span class="pageFontSubtitle" type="flex" justify="end">Bachelor of Engineering | TernaryProjectTeam Leader</span>
                </el-col>
            </el-row>
            <hr style="height: 1px; border: none; border-top: 1px solid #949494;" />
            <el-row>
                <el-col :span="12">
                    <el-row>man / ***8.12</el-row>
                    <el-row>Software Engineering Institute of Guangzhou</el-row>
                    <el-row>Major in Software Engineering</el-row>
                    <el-row>Undergraduate / Graduation June 2022</el-row>
                </el-col>
                <el-col :span="12">
                    <el-row>MainPage</el-row>
                    <el-row>GitHub</el-row>
                    <el-row>abc123@123.com</el-row>
                    <el-row>172000000</el-row>
                </el-col>
            </el-row>
            <page-main>
                <el-row>
                    <el-col :span="12">
                        <el-card>
                            1
                        </el-card>
                        <el-card>
                            3
                        </el-card>
                    </el-col>
                    <el-col :span="12">
                        <el-card>
                            2
                        </el-card>
                        <el-card>
                            4
                        </el-card>
                    </el-col>
                </el-row>
                <el-row>
                    <el-card>
                        5
                    </el-card>
                    <el-card>
                        6
                    </el-card>
                </el-row>
            </page-main>
            <span slot="footer" class="dialog-footer">
                <el-button @click="pageDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="pageDialogVisible = false">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
export default {
    name: 'Resume',
    components: {PageMain},
    data() {
        return {
            pageDialogVisible: false,
            search: '',
            pageTableHeaderUni: {
                id: '事务ID',
                position: '申请职位',
                positionStatus: '职位状态',
                department: '所属部门',
                name: '真实姓名',
                phone: '联系方式',
                director: '部门主管',
                phoneD: '主管电话',
                departmentStatus: '部门状态',
                description: '基本描述',
                createdTime: '创建时间',
                estimatedTime: '到期时间'
            },
            pagePropsValueUni: [
                {
                    id: '202202081948',
                    position: '开发工程师',
                    positionStatus: '目前空缺',
                    department: '软件部门',
                    name: 'Lewis',
                    phone: '12500000000',
                    director: 'Steven',
                    phoneD: '17600000000',
                    departmentStatus: 'full(已达部门标准人数)',
                    description: '梅赛德斯',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    id: '202202081949',
                    position: '辅导员',
                    positionStatus: '正在招聘',
                    department: '教辅部门',
                    name: 'Adam',
                    phone: '12500000000',
                    director: 'Seven',
                    phoneD: '17600000000',
                    departmentStatus: 'insufficiency(未达部门标准人数)',
                    description: '慕尼黑',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    id: '202202081950',
                    position: '人事主管',
                    positionStatus: '暂停招聘',
                    department: '人事部门',
                    name: 'Barbara',
                    phone: '12500000000',
                    director: 'Seven',
                    phoneD: '17600000000',
                    departmentStatus: 'overstaffed(已超部门最大人数)',
                    description: '柏林',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    id: '202202081951',
                    position: '人事经理',
                    positionStatus: '暂停招聘',
                    department: '人事部门',
                    name: 'North',
                    phone: '12600000000',
                    director: 'Seven',
                    phoneD: '17600000000',
                    departmentStatus: 'overstaffed(已超部门最大人数)',
                    description: '12321',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                }
            ]
        }
    },
    methods: {
        back() {
            history.go(-1)
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
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.pageFontTitle {
    font-family: 'Microsoft YaHei', serif;
    font-size: 36px;
}
.pageFontSubtitle {
    font-family: 'Microsoft YaHei', serif;
    font-size: 18px;
    position: absolute;
    bottom: 0;
}
.pageCol {
    position: absolute;
    right: 0;
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
