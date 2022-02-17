<template>
    <div>
        <page-header title="企业绩效">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置控制企业内部绩效</div>
                </div>
            </template>
        </page-header>
        <page-main title="绩效系统管理">
            <el-tabs tab-position="left">
                <el-tab-pane label="团队内部绩效考核">
                    <el-card calss="pageCard" shadow="hover">
                        参与本次考核 () 人 全员实记 () 人 <br>
                    </el-card>
                    <el-card class="pageCard" shadow="hover">
                        <el-row class="Echarts">
                            <div id="chartsUni" style="width: 670px; height: 430px;" />
                        </el-row>
                    </el-card>
                </el-tab-pane>
                <el-tab-pane label="企业内部绩效详情总表">
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
                <el-tab-pane label="企业部绩表">
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
    name: 'Performance',
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
    mounted() {
        this.echartsUni()
    },
    methods: {
        back() {
            history.go(-1)
        },
        echartsUni() {
            var chartUni = this.$echarts.init(document.getElementById('chartsUni'))
            let xAxisData = []
            let data1 = []
            let data2 = []
            let data3 = []
            let data4 = []
            for (let i = 0; i < 10; i++) {
                xAxisData.push('Class' + i)
                data1.push(+(Math.random() * 2).toFixed(2))
                data2.push(+(Math.random() * 5).toFixed(2))
                data3.push(+(Math.random() + 0.3).toFixed(2))
                data4.push(+Math.random().toFixed(2))
            }
            var emphasisStyle = {
                itemStyle: {
                    shadowBlur: 10,
                    shadowColor: 'rgba(0,0,0,0.3)'
                }
            }
            // 配置图表
            var option = {
                legend: {
                    data: ['bar', 'bar2', 'bar3', 'bar4'],
                    left: '10%'
                },
                toolbox: {
                    feature: {
                        magicType: {
                            type: ['stack']
                        },
                        dataView: {}
                    }
                },
                tooltip: {},
                xAxis: {
                    data: xAxisData,
                    name: 'X Axis',
                    axisLine: { onZero: true },
                    splitLine: { show: false },
                    splitArea: { show: false }
                },
                yAxis: {},
                grid: {
                    bottom: 100
                },
                series: [
                    {
                        name: 'bar',
                        type: 'bar',
                        stack: 'one',
                        emphasis: emphasisStyle,
                        data: data1
                    },
                    {
                        name: 'bar2',
                        type: 'bar',
                        stack: 'one',
                        emphasis: emphasisStyle,
                        data: data2
                    },
                    {
                        name: 'bar3',
                        type: 'bar',
                        stack: 'two',
                        emphasis: emphasisStyle,
                        data: data3
                    },
                    {
                        name: 'bar4',
                        type: 'bar',
                        stack: 'two',
                        emphasis: emphasisStyle,
                        data: data4
                    }
                ]
            }
            chartUni.setOption(option)
        }
    }
}
</script>
<style>
.pageCard {
    margin: 10px;
}
</style>
