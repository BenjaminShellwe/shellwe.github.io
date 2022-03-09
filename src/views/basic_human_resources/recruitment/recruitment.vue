<template>
    <div>
        <page-header title="招聘流程管理">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置管理企业招聘流程  !!暂不提供编辑!!</div>
                </div>
            </template>
        </page-header>
        <page-main>
            <el-table
                :data="pageTableData"
                style="width: 100%;"
                @row-click="pageVisible = !pageVisible"
            >
                <el-table-column type="expand">
                    <template slot="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                            <page>
                                1
                            </page>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column
                    label="招聘事务 ID"
                    prop="id"
                />
                <el-table-column
                    label="负责人员"
                    prop="name"
                />
                <el-table-column
                    label="描述"
                    prop="desc"
                />
            </el-table>
            <el-row v-show="pageVisible">
                <el-col :span="12">
                    <el-steps direction="vertical" :active="pageActiveUni" finish-status="success">
                        <el-button style="margin-bottom: 12px; width: 140px;" size="mini" @click="next(1)">下一步</el-button>
                        <el-step title="步骤 1" description="确定人员需求" />
                        <el-step title="步骤 2" description="指定招聘计划" />
                        <el-step title="步骤 3" description="应聘人员甄选" />
                        <el-step title="步骤 4" description="招聘评估结果" />
                    </el-steps>
                </el-col>
                <el-col :span="12">
                    <el-steps direction="vertical" :active="pageActiveBin" finish-status="success">
                        <el-button style="margin-bottom: 12px; width: 140px;" size="mini" @click="next(2)">下一步</el-button>
                        <el-step title="步骤 1" description="一、用人部门提出申请:部门经理向人事部门提出所需人数、岗位、要求、并解释理由;" />
                        <el-step title="步骤 2" description="二、人力资源部门复核,由最高管理层审核招聘计划" />
                        <el-step title="步骤 3" description="三、人事部根据部门递交的需求人员申请单，确定招聘的职位名称和所需的名额" />
                        <el-step title="步骤 4" description="四、对应聘人员的基本要求即资格及条件限制，比如该职位所限制的学历、要求的年龄、所需能力和经验等" />
                        <el-step title="步骤 5" description="五、所有招聘的职位的基本工资和预算工资的核定" />
                        <el-step title="步骤 6" description="六、制定及发布资料，准备通知单或公司宣传资料，申请办理日期" />
                        <el-step title="步骤 7" description="七、联系人才市场或张贴招聘通知；安排面试时间及场地和面试方式" />
                        <el-step title="步骤 8" description="八、最终确定人员，办理试用期入职手续，合格录用转正及手续" />
                        <el-step title="步骤 9" description="九、签订合同并存档" />
                    </el-steps>
                </el-col>
            </el-row>
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
export default {
    name: 'Recruit',
    components: {PageMain},
    data() {
        return {
            pageVisible: false,
            pageActiveUni: 0,
            pageActiveBin: 0,
            pageTableData: [{
                id: '12987122',
                name: 'Benjamin',
                desc: '不会有人来应聘的,死心吧'
            }]
        }
    },
    methods: {
        back() {
            history.go(-1)
        },
        next(i) {
            if (i == 1) {
                if (this.pageActiveUni++ > 3) this.pageActiveUni = 0
            }
            if (i == 2) {
                if (this.pageActiveBin++ > 8) this.pageActiveBin = 0
            }
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
</style>

