<template>
    <div>
        <page-header title="薪资管理汇总">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置控制企业薪资管理</div>
                </div>
            </template>
        </page-header>
        <page-main title="薪资信息总览">
            <el-card>
                <el-descriptions class="margin-top" title="基本工资结构组成情况" :column="2" size="medium" border>
                    <el-descriptions-item>
                        <template slot="label">
                            基础工资
                        </template>
                        基础工资即保障职工基本生活需要的工资。
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            岗位（职务）工资或技能工资
                        </template>
                        岗位工资或技能工资是根据岗位（职务）的技术、业务要求、劳动繁重程度、劳动条件好差、所负责任大小等因素来确定的。
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            效益工资
                        </template>
                        效益工资是根据企业的经济效益和职工实际完成的劳动的数量和质量支付给职工的工资。效益工资发挥着激励职工努力实干，多做贡献的作用。
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            浮动工资
                        </template>
                        浮动工资是劳动者劳动报酬随着企业经营好坏及劳动者劳动贡献大小而上下浮动的一种
                        <el-tag size="small">工资形式</el-tag>。
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            年功工资
                        </template>
                        年功工资是根据职工参加工作的年限，按照一定标准支付给职工的工资。
                    </el-descriptions-item>
                </el-descriptions>
            </el-card>
        </page-main>
        <page-main title="企业工资构成表">
            <el-tabs tab-position="left">
                <el-tab-pane label="企业内部职位工资组成表">
                    <el-table
                        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                    >
                        <el-table-column
                            label="职位"
                            prop="position"
                        />
                        <el-table-column label="基本工资">
                            <el-table-column
                                prop="basic"
                                label="基础工资"
                            />
                            <el-table-column
                                prop="skill"
                                label="岗位（职务）工资或技能工资"
                            />
                            <el-table-column
                                prop="benefit"
                                label="效益工资"
                            />
                            <el-table-column
                                prop="floating"
                                label="浮动工资"
                            />
                            <el-table-column
                                prop="seniority"
                                label="年功工资"
                            />
                        </el-table-column>
                        <el-table-column
                            align="right"
                            width="155px"
                        >
                            <template slot="header">
                                <el-input
                                    v-model="search"
                                    size="mini"
                                    placeholder="输入关键字搜索"
                                />
                            </template>
                            <template>
                                <el-button
                                    size="mini"
                                >
                                    编辑
                                </el-button>
                                <el-button
                                    size="mini"
                                    type="danger"
                                >
                                    停用
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
                <el-tab-pane label="企业工资组成详情细则表">
                    <el-table
                        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                    >
                        <el-table-column
                            label="事务ID"
                            prop="id"
                        />
                        <el-table-column
                            label="职位"
                            prop="position"
                        />
                        <el-table-column
                            label="工资"
                            prop="salary"
                        />
                        <el-table-column
                            label="工资组成形式"
                            prop="formation"
                        />
                        <el-table-column
                            align="right"
                            width="155px"
                        >
                            <template slot="header">
                                <el-input
                                    v-model="search"
                                    size="mini"
                                    placeholder="输入关键字搜索"
                                />
                            </template>
                            <template>
                                <el-button
                                    size="mini"
                                >
                                    编辑
                                </el-button>
                                <el-button
                                    size="mini"
                                    type="danger"
                                >
                                    停用
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
                <el-tab-pane label="企业工资发放统计细则表">
                    <el-table
                        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                    >
                        <el-table-column
                            label="事务ID"
                            prop="id"
                        />
                        <el-table-column
                            label="部门"
                            prop="id"
                        />
                        <el-table-column
                            label="工资发放情况"
                            prop="status"
                        />
                        <el-table-column
                            align="right"
                            width="155px"
                        >
                            <template slot="header">
                                <el-input
                                    v-model="search"
                                    size="mini"
                                    placeholder="输入关键字搜索"
                                />
                            </template>
                            <template>
                                <el-button
                                    size="mini"
                                >
                                    查看
                                </el-button>
                                <el-button
                                    size="mini"
                                    type="danger"
                                >
                                    处理
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
export default {
    name: 'Summary',
    components: {PageMain},
    data() {
        return {
            search: '',
            tableData:
                [
                    {
                        id: '202102101712',
                        salary: '7k',
                        position: '主管',
                        basic: '5000',
                        skill: '1000',
                        benefit: '1000',
                        floating: '800',
                        seniority: '800',
                        formation: '基本工资+考勤状况+绩效考核+额外奖金',
                        department: '人事部',
                        status: '已发放且无异常'
                    },
                    {
                        id: '202102101713',
                        salary: '1.2w',
                        position: '经理',
                        basic: '7000',
                        skill: '1500',
                        benefit: '1000',
                        floating: '800',
                        seniority: '800',
                        formation: '基本工资+考勤状况+绩效考核+额外奖金',
                        department: '人事部',
                        status: '已发放且无异常'
                    },
                    {
                        id: '202102101714',
                        salary: '4k',
                        position: '教辅员',
                        basic: '3000',
                        skill: '500',
                        benefit: '1000',
                        floating: '800',
                        seniority: '800',
                        formation: '基本工资+考勤状况+绩效考核',
                        department: '教辅部',
                        status: '已发放但有异常'
                    },
                    {
                        id: '2016-05-03',
                        salary: '2w',
                        position: '总负责',
                        basic: '8000',
                        skill: '500',
                        benefit: '1000',
                        floating: '800',
                        seniority: '800',
                        formation: '基本工资+考勤状况+绩效考核+分红',
                        department: '总务部',
                        status: '已发放但有异常'
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

