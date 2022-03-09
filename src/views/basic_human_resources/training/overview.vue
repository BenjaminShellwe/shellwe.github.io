<template>
    <div>
        <page-header title="企业员工培训">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置控制企业员工培训信息</div>
                </div>
            </template>
        </page-header>
        <page-main title="企业员工培训">
            <el-tabs tab-position="left">
                <el-tab-pane label="发布培训计划">
                    <el-alert
                        title="此处是发布新培训,不是编辑培训内容或流程.请注意!!"
                        type="warning"
                        style="margin-bottom: 5px;"
                    />
                    <el-row :gutter="16">
                        <el-col :span="6">
                            <el-card shadow="hover" class="pageCard">
                                <el-descriptions class="margin-top" title="默认培训" :column="1" size="mini" border>
                                    <template slot="extra">
                                        <el-button type="primary" size="small">操作</el-button>
                                    </template>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训内容
                                        </template>
                                        企业内部文化及管理
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训方式
                                        </template>
                                        线上课程及线下讲解
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训地点
                                        </template>
                                        员工培训室内
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            备注
                                        </template>
                                        <el-tag size="small">必须培训</el-tag>
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训负责人
                                        </template>
                                        shellwe
                                    </el-descriptions-item>
                                </el-descriptions>
                            </el-card>
                        </el-col>
                        <el-col :span="6">
                            <el-card shadow="hover" class="pageCard">
                                <el-descriptions class="margin-top" title="技能培训" :column="1" size="mini" border>
                                    <template slot="extra">
                                        <el-button type="primary" size="small">操作</el-button>
                                    </template>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训内容
                                        </template>
                                        岗位工作内容培训
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训方式
                                        </template>
                                        线下课程及讲解
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训地点
                                        </template>
                                        员工培训室内
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            备注
                                        </template>
                                        <el-tag size="small">必须培训</el-tag>
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训负责人
                                        </template>
                                        shellwe
                                    </el-descriptions-item>
                                </el-descriptions>
                            </el-card>
                        </el-col>
                        <el-col :span="6">
                            <el-card shadow="hover" class="pageCard">
                                <el-descriptions class="margin-top" title="素质培训" :column="1" size="mini" border>
                                    <template slot="extra">
                                        <el-button type="primary" size="small">操作</el-button>
                                    </template>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训内容
                                        </template>
                                        心理素质,工作态度及习惯
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训方式
                                        </template>
                                        线下讲解
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训地点
                                        </template>
                                        员工培训室内
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            备注
                                        </template>
                                        <el-tag size="small">必须培训</el-tag>
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训负责人
                                        </template>
                                        shellwe
                                    </el-descriptions-item>
                                </el-descriptions>
                            </el-card>
                        </el-col>
                        <el-col :span="6">
                            <el-card shadow="hover" class="pageCard">
                                <el-descriptions class="margin-top" title="创建培训" :column="1" size="mini" border>
                                    <template slot="extra">
                                        <el-button type="primary" size="small">操作</el-button>
                                    </template>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训内容
                                        </template>
                                        由管理员创建
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训方式
                                        </template>
                                        可选
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训地点
                                        </template>
                                        可选
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            备注
                                        </template>
                                        <el-tag size="small">非必须</el-tag>
                                    </el-descriptions-item>
                                    <el-descriptions-item>
                                        <template slot="label">
                                            培训负责人
                                        </template>
                                        即培训创建人
                                    </el-descriptions-item>
                                </el-descriptions>
                            </el-card>
                        </el-col>
                    </el-row>
                </el-tab-pane>
                <el-tab-pane label="培训内容编辑">
                    <el-tabs v-model="pageTab" type="card">
                        <el-tab-pane label="培训内容管理" name="first">
                            <el-table
                                :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                                style="width: 100%;"
                                border
                            >
                                <el-table-column
                                    label="事务ID"
                                    prop="id">
                                </el-table-column>
                                <el-table-column
                                    label="负责人"
                                    prop="name">
                                </el-table-column>
                                <el-table-column
                                    label="培训内容"
                                    prop="trainingType">
                                </el-table-column>
                                <el-table-column
                                    width="170px"
                                    align="right">
                                    <template slot="header">
                                        <el-input
                                            v-model="search"
                                            size="mini"
                                            placeholder="输入关键字搜索"
                                            style="width: 130px;"
                                        />
                                    </template>
                                    <template
                                        style="width: 130px;"
                                    >
                                        <el-button
                                            size="mini"
                                        >编辑</el-button>
                                        <el-button
                                            size="mini"
                                            type="danger"
                                        >删除</el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </el-tab-pane>
                        <el-tab-pane label="培训结果生成" name="fourth">
                            <el-table
                                :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                                style="width: 100%;"
                                border
                            >
                                <el-table-column
                                    label="事务ID"
                                    prop="id">
                                </el-table-column>
                                <el-table-column
                                    label="员工姓名"
                                    prop="name">
                                </el-table-column>
                                <el-table-column
                                    label="培训结果"
                                    prop="trainingType">
                                </el-table-column>
                                <el-table-column
                                    width="170px"
                                    align="right">
                                    <template slot="header">
                                        <el-input
                                            v-model="search"
                                            size="mini"
                                            placeholder="输入关键字搜索"
                                            style="width: 130px;"
                                        />
                                    </template>
                                    <template
                                        style="width: 130px;"
                                    >
                                        <el-button
                                            size="mini"
                                        >查看</el-button>
                                        <el-button
                                            size="mini"
                                            type="success"
                                        >打印</el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </el-tab-pane>
                    </el-tabs>
                </el-tab-pane>
                <el-tab-pane label="培训计划详情">
                    <el-card shadow="hover" style="margin: 5px;">
                        <template>
                            <el-table
                                :data="tableData"
                                style="width: 100%;"
                            >
                                <el-table-column label="已发布计划">
                                    <el-table-column
                                        prop="id"
                                        label="事务ID"
                                    />
                                    <el-table-column
                                        prop="name"
                                        label="负责人"
                                    />
                                    <el-table-column label="培训计划详情">
                                        <el-table-column
                                            prop="trainingType"
                                            label="培训类型"
                                        />
                                        <el-table-column
                                            prop="trainingMethods"
                                            label="培训方式"
                                        />
                                        <el-table-column
                                            prop="trainingContent"
                                            label="培训内容/名称"
                                        />
                                        <el-table-column
                                            prop="notes"
                                            label="备注"
                                        />
                                    </el-table-column>
                                    <el-table-column
                                        fixed="right"
                                        label="操作"
                                        width="120"
                                    >
                                        <template >
                                            <el-button type="text" size="small">移除</el-button>
                                            <el-button type="text" size="small">允许</el-button>
                                            <el-button type="text" size="small">编辑</el-button>
                                        </template>
                                    </el-table-column>
                                </el-table-column>
                            </el-table>
                        </template>
                    </el-card>
                    <el-card shadow="hover" style="margin: 5px;">
                        <template>
                            <el-table
                                :data="tableData"
                                style="width: 100%;"
                            >
                                <el-table-column label="未发布计划">
                                    <el-table-column
                                        prop="id"
                                        label="事务ID"
                                    />
                                    <el-table-column
                                        prop="name"
                                        label="负责人"
                                    />
                                    <el-table-column label="培训计划详情">
                                        <el-table-column
                                            prop="trainingType"
                                            label="培训类型"
                                        />
                                        <el-table-column
                                            prop="trainingMethods"
                                            label="培训方式"
                                        />
                                        <el-table-column
                                            prop="trainingContent"
                                            label="培训内容/名称"

                                        />
                                        <el-table-column
                                            prop="notes"
                                            label="备注"
                                        />
                                    </el-table-column>
                                    <el-table-column
                                        fixed="right"
                                        label="操作"
                                        width="120"
                                    >
                                        <template >
                                            <el-button type="text" size="small">移除</el-button>
                                            <el-button type="text" size="small">允许</el-button>
                                            <el-button type="text" size="small">编辑</el-button>
                                        </template>
                                    </el-table-column>
                                </el-table-column>
                            </el-table>
                        </template>
                    </el-card>
                </el-tab-pane>
            </el-tabs>
        </page-main>
    </div>
</template>

<script>

export default {
    name: 'Overview',
    data() {
        return {
            pageTab: 'first',
            search: '',
            tableData:
                [
                    {
                        id: '202102101712',
                        salary: '7k',
                        position: '主管'
                    },
                    {
                        id: '202102101713',
                        salary: '1.2w',
                        position: '经理'
                    },
                    {
                        id: '202102101714',
                        salary: '4k',
                        position: '教辅员'
                    },
                    {
                        id: '2016-05-03',
                        salary: '2w',
                        position: '总负责'
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
.pageCard {
    margin-left: 10px;
    margin-right: 10px;
}
</style>
