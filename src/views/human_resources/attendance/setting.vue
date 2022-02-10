<template>
    <div>
        <page-header title="企业考勤管理">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置控制企业考勤</div>
                </div>
            </template>
        </page-header>
        <page-main title="企业员工考勤">
            <el-tabs tab-position="left">
                <el-tab-pane label="企业内部职位组成表">
                    <el-table
                        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                    >
                        <el-table-column
                            label="事务ID"
                            prop="id"
                        />
                        <el-table-column
                            label="工资"
                            prop="salary"
                        />
                        <el-table-column
                            align="right"
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
                                    Edit
                                </el-button>
                                <el-button
                                    size="mini"
                                    type="danger"
                                >
                                    Delete
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
                <el-tab-pane label="企业内培训负责人表">
                    <el-table
                        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                    >
                        <el-table-column
                            label="事务ID"
                            prop="id"
                        />
                        <el-table-column
                            label="工资"
                            prop="salary"
                        />
                        <el-table-column
                            align="right"
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
                                    Edit
                                </el-button>
                                <el-button
                                    size="mini"
                                    type="danger"
                                >
                                    Delete
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
                <el-tab-pane label="企业内部培训详情表">
                    <el-table
                        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                    >
                        <el-table-column
                            label="事务ID"
                            prop="id"
                        />
                        <el-table-column
                            label="工资"
                            prop="salary"
                        />
                        <el-table-column
                            align="right"
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
                                    Edit
                                </el-button>
                                <el-button
                                    size="mini"
                                    type="danger"
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
export default {
    name: 'Setting',
    data() {
        return {
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

