<template>
    <div>
        <page-header title="数据统计">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                <div class="inLine">
                    此页为系统的数据统计
                </div>
            </template>
        </page-header>
        <page-main title="企业招聘数据统计">
            <el-row style="padding: 2px 0;">
                <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                    <div slot="header" class="clearfix">
                        <span>外部招聘源盘点 开发中 (点击右边进行操作)</span>
                        <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                    </div>
                    <el-tabs tab-position="left" class="pageTabCSS">
                        <el-tab-pane label="招聘选拔">

                        </el-tab-pane>
                        <el-tab-pane label="人才推荐">
                            <el-tabs tab-position="top" style="height: 200px;">
                                <el-tab-pane label="行业推荐">行业推荐</el-tab-pane>
                                <el-tab-pane label="猎头推荐">猎头推荐</el-tab-pane>
                                <el-tab-pane label="内部推荐">内部推荐</el-tab-pane>
                            </el-tabs>
                        </el-tab-pane>
                        <el-tab-pane label="对应关系">
                            <span>针对同行或竞争对手公司进行组织价格摸底,了解关键人和职责</span>
                            <span>由某一关键人作为切入点,找到上下级,并反复验证</span>
                        </el-tab-pane>
                    </el-tabs>
                </el-card>
            </el-row>
            <el-row style="padding: 2px 0;">
                <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                    <div slot="header" class="clearfix">
                        <span>内部信息源盘点 开发中 (点击右边进行操作)</span>
                        <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                    </div>
                    <el-tabs tab-position="left" class="pageTabCSS">
                        <el-tab-pane label="在职人才">
                            <h2>在职员工</h2>
                            <el-tabs tab-position="top" style="height: 200px;">
                                <el-tab-pane label="内部竞聘">内部竞聘</el-tab-pane>
                                <el-tab-pane label="内部竞升">内部竞升</el-tab-pane>
                                <el-tab-pane label="内部培训">内部培训</el-tab-pane>
                            </el-tabs>
                        </el-tab-pane>
                        <el-tab-pane label="离职人才">
                            <h2>离职职员</h2>
                            <el-tabs tab-position="top" style="height: 200px;">
                                <el-tab-pane label="定期跟踪近况">定期跟踪近况</el-tab-pane>
                                <el-tab-pane label="离职福利关怀">离职福利关怀</el-tab-pane>
                                <el-tab-pane label="邀请参加活动">邀请参加活动</el-tab-pane>
                            </el-tabs>
                        </el-tab-pane>
                    </el-tabs>
                </el-card>
            </el-row>
            <el-row style="padding: 2px 0;">
                <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                    <div slot="header" class="clearfix">
                        <span>招聘统计分析 开发中 (点击右边进行操作)</span>
                        <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                    </div>
                    <el-tabs tab-position="left" class="pageTabCSS">
                        <el-tab-pane label="渠道有效性分析">
                            <h2>渠道有效性分析</h2>
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
                        </el-tab-pane>
                        <el-tab-pane label="周期与成本分析">
                            <h2>周期与成本分析</h2>
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
                        </el-tab-pane>
                        <el-tab-pane label="招聘任务及统计">
                            <h2>招聘任务及统计</h2>
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
                        </el-tab-pane>
                    </el-tabs>
                </el-card>
            </el-row>
        </page-main>
        <page-main title="业务数据统计">
            设计中
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Statistic',
    components: {PageMain, PageHeader},
    data() {
        return {
            value: new Date(),
            search: '',
            pageActiveCollapse: '',
            pageTableHeaderUni: {
                id: '事务ID',
                position: '职位',
                positionStatus: '职位状态',
                department: '部门',
                departmentStatus: '部门状态',
                CV: '收到简历',
                passCV: '初筛合格简历',
                effective: '有效率',
                present: '通知后到场者',
                attendance: '到场率',
                pass: '初试通过',
                passRate: '通过率',
                description: '基本描述'
            },
            pagePropsValueUni: [
                {
                    id: '202202122333',
                    position: '经理',
                    positionStatus: '缺乏',
                    department: '项目管理部',
                    departmentStatus: 'insufficiency(未达部门标准人数)',
                    CV: '50',
                    passCV: '25',
                    effective: '50%',
                    present: '13',
                    attendance: '26%',
                    pass: '5',
                    passRate: '38%',
                    description: '基本描述'
                },
                {
                    id: '202202122334',
                    position: '文秘',
                    positionStatus: '缺乏',
                    department: '总务部',
                    departmentStatus: 'sufficiency(达到部门标准人数)',
                    CV: '50',
                    passCV: '25',
                    effective: '50%',
                    present: '13',
                    attendance: '26%',
                    pass: '5',
                    passRate: '38%',
                    description: '基本描述'
                },
                {
                    id: '202202122336',
                    position: '网络工程师',
                    positionStatus: '缺乏',
                    department: '网络系统部',
                    departmentStatus: 'sufficiency(达到部门标准人数)',
                    CV: '50',
                    passCV: '25',
                    effective: '50%',
                    present: '13',
                    attendance: '26%',
                    pass: '5',
                    passRate: '38%',
                    description: '基本描述'
                },
                {
                    id: '202202122339',
                    position: '研发工程师',
                    positionStatus: '缺乏',
                    department: '网络系统部',
                    departmentStatus: 'sufficiency(达到部门标准人数)',
                    CV: '50',
                    passCV: '25',
                    effective: '50%',
                    present: '13',
                    attendance: '26%',
                    pass: '5',
                    passRate: '38%',
                    description: '基本描述'
                }
            ]
        }
    },
    mounted() {
        this.echartsUni()
        this.echartsBin()
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleChange(val) {
            console.log(val)
        },
        handleEdit(index, row) {
            console.log(index, row)
        },
        handleDelete(index, row) {
            console.log(index, row)
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.pageTabCSS {
    height: auto;
    min-height: 150px;
}
</style>
