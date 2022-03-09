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
                    <el-main>
                        <el-card style="margin-left: 10px; margin-right: 10px;" shadow="hover">
                            参与本次考核 () 人 全员实记 ( ) 人 <br>
                        </el-card>
                        <el-card class="pageCard" shadow="hover">
                            <el-row>
                                <el-col class="Echarts" :span="13" style="height: 330px;">
                                    <div id="chartsUni" style="width: 660px; height: 400px;" />
                                </el-col>
                                <el-col :span="10">
                                    <el-table
                                        :data="tableData"
                                        style="width: 100%;"
                                    >
                                        <el-table-column
                                            prop="department"
                                            label="部门"
                                        />
                                        <el-table-column
                                            prop="proportion"
                                            label="占比"
                                        />

                                        <el-table-column
                                            prop="completion"
                                            label="完成度"
                                        />
                                    </el-table>
                                </el-col>
                            </el-row>
                        </el-card>
                        <el-row class="pageCard">
                            <el-col :span="12">
                                <el-card class="Echarts" style="margin-right: 5px;" shadow="hover">
                                    <div id="chartsBin" style="width: 660px; height: 310px;" />
                                </el-card>
                            </el-col>
                            <el-col :span="12">
                                <el-card class="Echarts" style="margin-left: 5px;" shadow="hover">
                                    <div id="chartsTer" style="width: 660px; height: 310px;" />
                                </el-card>
                            </el-col>
                        </el-row>
                        <el-row class="pageCard">
                            <el-col :span="12">
                                <el-card class="Echarts" style="margin-right: 5px;" shadow="hover">
                                    <div id="chartsQua" style="width: 600px; height: 310px;" />
                                </el-card>
                            </el-col>
                            <el-col :span="12">
                                <el-card class="Echarts" style="margin-left: 5px;" shadow="hover">
                                    <div id="chartsQui" style="width: 660px; height: 310px;" />
                                </el-card>
                            </el-col>
                        </el-row>
                        <el-row class="pageCard">
                            <el-col :span="12">
                                <el-card class="Echarts" style="margin-right: 5px;" shadow="hover">
                                    <div id="chartsSen" style="width: 660px; height: 310px;" />
                                </el-card>
                            </el-col>
                            <el-col :span="12">
                                <el-card style="margin-left: 5px;" shadow="hover">
                                    <h3>绩效数据异常预警</h3>
                                    <el-table
                                        :data="tableData"
                                        border
                                        height="248"
                                        style="width: 100%;"
                                    >
                                        <el-table-column
                                            prop="name"
                                            label="员工姓名"
                                        />
                                        <el-table-column
                                            prop="department"
                                            label="所属部门"
                                        />
                                        <el-table-column
                                            prop="expression"
                                            label="表现"
                                        />
                                        <el-table-column
                                            prop="rules"
                                            label="规则"
                                        />
                                    </el-table>
                                </el-card>
                            </el-col>
                        </el-row>
                    </el-main>
                </el-tab-pane>
                <el-tab-pane label="企业内部绩效详情总表">
                    <el-table
                        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                    >
                        <el-table-column
                            label="团队"
                            prop="team"
                        />
                        <el-table-column
                            label="绩效总览"
                            prop="performance"
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

import axios from 'axios'

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
                        position: '主管',
                        name: 'Elsa',
                        department: '人事部',
                        rules: '规则1',
                        team: 't1',
                        performance: '4.1',
                        proportion: '75%',
                        completion: '88%',
                        expression: '1.2'
                    },
                    {
                        id: '202102101713',
                        salary: '1.2w',
                        position: '经理',
                        name: 'Elsa',
                        department: '人事部',
                        rules: '规则1',
                        team: 't2',
                        performance: '5.1',
                        proportion: '95%',
                        completion: '95%',
                        expression: '1.2'
                    },
                    {
                        id: '202102101714',
                        salary: '4k',
                        position: '教辅员',
                        name: 'Anna',
                        department: '教辅部',
                        rules: '规则2',
                        team: 't3',
                        performance: '6.2',
                        proportion: '75%',
                        completion: '85%',
                        expression: '3.2'
                    },
                    {
                        id: '2016-05-03',
                        salary: '2w',
                        position: '总负责',
                        name: 'Hanson',
                        department: '总务部',
                        rules: '规则3',
                        team: 't4',
                        performance: '6.1',
                        proportion: '76%',
                        completion: '75%',
                        expression: '2.2'
                    }
                ]
        }
    },
    mounted() {
        this.handleQueryValue()
        this.echartsUni()
        this.echartsBin()
        this.echartsTer()
        this.echartsQua()
        this.echartsQui()
        this.echartsSen()
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
                    right: '10%',
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
        },
        echartsBin() {
            var chartBin = this.$echarts.init(document.getElementById('chartsBin'))
            // 配置图表
            var option = {
                title: {
                    text: '绩效总分分布情况',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: 'Access From',
                        type: 'pie',
                        radius: ['25%', '60%'],
                        data: [
                            { value: 1048, name: 'Search Engine' },
                            { value: 735, name: 'Direct' },
                            { value: 580, name: 'Email' },
                            { value: 484, name: 'Union Ads' },
                            { value: 300, name: 'Video Ads' }
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            }
            chartBin.setOption(option)
        },
        echartsTer() {
            var chartTer = this.$echarts.init(document.getElementById('chartsTer'))
            const builderJson = {
                all: 2582,
                charts: {
                    map: 327,
                    lines: 214,
                    bar: 561,
                    line: 778,
                    pie: 355,
                    scatter: 205,
                    candlestick: 142

                },
                ie: 743
            }
            const downloadJson = {
                'echarts.min.js': 17365,
                'echarts.simple.min.js': 4079,
                'echarts.common.min.js': 6929,
                'echarts.js': 14890
            }
            const waterMarkText = 'ECHARTS'
            const canvas = document.createElement('canvas')
            const ctx = canvas.getContext('2d')
            canvas.width = canvas.height = 100
            ctx.textAlign = 'center'
            ctx.textBaseline = 'middle'
            ctx.globalAlpha = 0.08
            ctx.font = '20px Microsoft Yahei'
            ctx.translate(50, 50)
            ctx.rotate(-Math.PI / 4)
            ctx.fillText(waterMarkText, 0, 0)
            // 配置图表
            var option = {
                title: [
                    {
                        text: '加分项分布情况',
                        subtext: '总计 ' + builderJson.all,
                        left: '20%',
                        textAlign: 'center'
                    },
                    {
                        text: '分布情况细则',
                        subtext:
                            '总计 ' +
                            Object.keys(downloadJson).reduce(function(all, key) {
                                return all + downloadJson[key]
                            }, 0),
                        left: '65%',
                        textAlign: 'center'
                    }
                ],
                tooltip: {
                    trigger: 'item'
                },
                grid: [
                    {
                        top: 50,
                        width: '35%',
                        bottom: '1%',
                        left: 5,
                        containLabel: true
                    }
                ],
                xAxis: [
                    {
                        type: 'value',
                        max: builderJson.all,
                        splitLine: {
                            show: false
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'category',
                        data: Object.keys(builderJson.charts),
                        axisLabel: {
                            interval: 0,
                            rotate: 30
                        },
                        splitLine: {
                            show: false
                        }
                    }
                ],
                series: [
                    {
                        type: 'bar',
                        stack: 'chart',
                        z: 3,
                        label: {
                            position: 'right',
                            show: true
                        },
                        data: Object.keys(builderJson.charts).map(function(key) {
                            return builderJson.charts[key]
                        })
                    },
                    {
                        type: 'bar',
                        stack: 'chart',
                        silent: true,
                        itemStyle: {
                            color: '#eee'
                        },
                        data: Object.keys(builderJson.charts).map(function(key) {
                            return builderJson.all - builderJson.charts[key]
                        })
                    },
                    {
                        type: 'pie',
                        radius: ['30%', '50%'],
                        center: ['65%', '50%'],
                        data: Object.keys(downloadJson).map(function(key) {
                            return {
                                name: key.replace('.js', ''),
                                value: downloadJson[key]
                            }
                        }),
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            }
            chartTer.setOption(option)
        },
        echartsQua() {
            var chartQua = this.$echarts.init(document.getElementById('chartsQua'))
            // 配置图表
            var option = {
                title: [
                    {
                        text: '各部门总分情况'
                    },
                    {
                        text: '',
                        subtext: '分类一',
                        top: '5%',
                        left: '15%',
                        textAlign: 'center'
                    },
                    {
                        text: '',
                        subtext: '分类二',
                        top: '5%',
                        left: '48%',
                        textAlign: 'center'
                    },
                    {
                        text: '',
                        subtext: '分类三',
                        top: '5%',
                        left: '81%',
                        textAlign: 'center'
                    }
                ],
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                legend: {},
                grid: [
                    {
                        left: '0%',
                        right: '5%',
                        bottom: '3%',
                        width: '35%',
                        containLabel: true
                    },
                    {
                        left: '39%',
                        right: '5%',
                        bottom: '3%',
                        width: '26%',
                        containLabel: true
                    },
                    {
                        left: '70%',
                        right: '0%',
                        bottom: '3%',
                        width: '26%',
                        containLabel: true
                    }
                ],
                xAxis: [
                    {
                        type: 'value',
                        gridIndex: 0
                    },
                    {
                        type: 'value',
                        gridIndex: 1
                    },
                    {
                        type: 'value',
                        gridIndex: 2
                    }
                ],
                yAxis: [
                    {
                        type: 'category',
                        data: ['1111', '2', '3', '4', '5', '6'],
                        gridIndex: 0,
                        axisLabel: {
                            interval: 0,
                            rotate: 70
                        }
                    },
                    {
                        type: 'category',
                        data: [],
                        gridIndex: 1
                    },
                    {
                        type: 'category',
                        data: [],
                        gridIndex: 2}
                ],
                series: [
                    {
                        type: 'bar',
                        data: [18, 23, 29, 10, 14, 23],
                        xAxisIndex: 0, yAxisIndex: 0
                    },
                    {
                        type: 'bar',
                        data: [13, 23, 21, 12, 11, 7],
                        xAxisIndex: 1, yAxisIndex: 1
                    },
                    {
                        type: 'bar',
                        data: [8, 13, 20, 2, 22, 6],
                        xAxisIndex: 2, yAxisIndex: 2
                    }
                ]
            }
            chartQua.setOption(option)
        },
        echartsQui() {
            var chartQui = this.$echarts.init(document.getElementById('chartsQui'))
            // 配置图表
            var option = {
                title: {
                    text: '加分项对比',
                    left: 'left'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    data: ['Allocated Budget', 'Actual Spending'],
                    orient: 'vertical',
                    left: 'left',
                    top: 'center'
                },
                radar: {
                    // shape: 'circle',
                    indicator: [
                        { name: 'Sales', max: 650 },
                        { name: 'Administration', max: 360},
                        { name: 'Information Technology', max: 500 },
                        { name: 'Customer Support', max: 380 },
                        { name: 'Development', max: 520 },
                        { name: 'Marketing', max: 250 }
                    ]
                },
                series: [
                    {
                        name: 'Budget vs spending',
                        type: 'radar',
                        data: [
                            {
                                value: [420, 300, 200, 350, 500, 180],
                                name: 'Allocated Budget'
                            },
                            {
                                value: [500, 140, 280, 260, 420, 210],
                                name: 'Actual Spending'
                            }
                        ]
                    }
                ]
            }
            chartQui.setOption(option)
        },
        echartsSen() {
            var chartSen = this.$echarts.init(document.getElementById('chartsSen'))
            // 配置图表
            var option = {
                title: {
                    text: '自评和主管评分落差'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['一档', '二档', '三档', '四档', '五档']
                },
                grid: {
                    left: '5%',
                    right: '10%',
                    top: '15%',
                    bottom: '8%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    name: '自评',
                    nameLocation: 'center',
                    nameTextStyle: {
                        lineHeight: 50
                    },
                    type: 'category',
                    boundaryGap: false,
                    data: ['1', '2', '3', '4', '5', '6', '7']
                },
                yAxis: {
                    name: '主管评',
                    nameLocation: 'center',
                    nameTextStyle: {
                        lineHeight: 50
                    },
                    type: 'value'
                },
                series: [
                    {
                        name: '一档',
                        type: 'line',
                        data: [1.20, 1.32, 1.01, 1.34, 0.90, 2.30, 2.10]
                    },
                    {
                        name: '二档',
                        type: 'line',
                        data: [2.20, 1.82, 1.91, 2.34, 2.90, 3.30, 3.10]
                    },
                    {
                        name: '三档',
                        type: 'line',
                        data: [1.50, 2.32, 2.01, 1.54, 1.90, 3.30, 4.10]
                    },
                    {
                        name: '四档',
                        type: 'line',
                        data: [3.20, 3.32, 3.01, 3.34, 3.90, 3.30, 3.20]
                    },
                    {
                        name: '五档',
                        type: 'line',
                        data: [3.20, 4.32, 4.01, 2.34, 1.290, 1.330, 1.320]
                    }
                ]
            }
            chartSen.setOption(option)
        },
        handleQueryValue() {
            const that = this
            axios({
                method: 'post',
                url: '/performance/queryAll'
            }).then(function(response) {
                // console.log(response)
                that.tableData = response.data.data
            }).catch(function(error) {
                console.log(error)
            })
        }
    }
}
</script>
<style>
.pageCard {
    margin-top: 10px;
}
</style>
