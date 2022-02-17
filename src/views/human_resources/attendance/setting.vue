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
                <el-tab-pane label="员工出勤统计">
                    <el-main>
                        <el-row>
                            <el-col class="Echarts" :span="9">
                                <el-card id="chartsUni" style="width: 470px; height: 430px;" shadow="hover" />
                            </el-col>
                            <el-col class="Echarts" :span="8">
                                <el-card id="chartsBin" style="width: 470px; height: 430px;" shadow="hover" />
                            </el-col>
                        </el-row>
                    </el-main>
                </el-tab-pane>
                <el-tab-pane label="部门状态统计">
                    <el-main>
                        <el-row>
                            <el-col class="Echarts" :span="19">
                                <el-card id="chartsTer" style="width: 870px; height: 550px;" shadow="hover" />
                            </el-col>
                            <el-col :span="4">
                                <el-card>
                                    操作1-3
                                </el-card>
                            </el-col>
                        </el-row>
                    </el-main>
                </el-tab-pane>
                <el-tab-pane label="员工事务申请">
                    <el-table
                        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%;"
                        border
                    >
                        <el-table-column
                            label="事务ID"
                            prop="id"
                        />
                        <el-table-column
                            label="类型"
                            prop="salary"
                        />
                        <el-table-column
                            align="right"
                            width="155px"
                        >
                            <template slot="header">
                                <el-input
                                    v-model="search"
                                    size="mini"
                                    placeholder="输入关键字类型搜索"
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

import * as echarts from 'echarts'

export default {
    name: 'Setting',
    data() {
        return {
            search: '',
            tableData:
                [
                    {
                        id: '202102101712',
                        salary: '请假',
                        position: '主管'
                    },
                    {
                        id: '202102101713',
                        salary: '请假',
                        position: '经理'
                    },
                    {
                        id: '202102101714',
                        salary: '补签',
                        position: '教辅员'
                    },
                    {
                        id: '2016-05-03',
                        salary: '补签',
                        position: '总负责'
                    }
                ]
        }
    },
    mounted() {
        this.echartsUni()
        this.echartsBin()
        this.echartsTer()
    },
    methods: {
        back() {
            history.go(-1)
        },
        echartsUni() {
            var chartUni = this.$echarts.init(document.getElementById('chartsUni'))
            const graphData = [
                ['2022-02-01', 26],
                ['2022-02-04', 30],
                ['2022-02-09', 47],
                ['2022-02-13', 54],
                ['2022-02-18', 74],
                ['2022-02-23', 91]
            ]
            const links = graphData.map(function(item, idx) {
                return {
                    source: idx,
                    target: idx + 1
                }
            })
            function getVirtulData(year) {
                year = year || '2022'
                var date = +echarts.number.parseDate(year + '-01-01')
                var end = +echarts.number.parseDate(+year + 1 + '-01-01')
                var dayTime = 3600 * 24 * 1000
                var data = []
                for (var time = date; time < end; time += dayTime) {
                    data.push([
                        echarts.format.formatTime('yyyy-MM-dd', time),
                        Math.floor(Math.random() * 100)
                    ])
                }
                return data
            }
            links.pop()
            // 配置图表
            var option = {
                tooltip: {},
                calendar: {
                    top: 'middle',
                    left: 'center',
                    orient: 'vertical',
                    cellSize: 40,
                    yearLabel: {
                        margin: 50,
                        fontSize: 30
                    },
                    dayLabel: {
                        firstDay: 0,
                        nameMap: 'cn'
                    },
                    monthLabel: {
                        nameMap: 'cn',
                        margin: 15,
                        fontSize: 20,
                        color: '#999'
                    },
                    range: ['2022-02']
                },
                visualMap: {
                    min: 0,
                    max: 100,
                    type: 'piecewise',
                    left: 'center',
                    bottom: 20,
                    inRange: {
                        color: ['#5291FF', '#C7DBFF']
                    },
                    seriesIndex: [1],
                    orient: 'horizontal'
                },
                series: [
                    {
                        type: 'graph',
                        edgeSymbol: ['none', 'arrow'],
                        coordinateSystem: 'calendar',
                        links: links,
                        symbolSize: 15,
                        calendarIndex: 0,
                        itemStyle: {
                            color: 'yellow',
                            shadowBlur: 9,
                            shadowOffsetX: 1.5,
                            shadowOffsetY: 3,
                            shadowColor: '#555'
                        },
                        lineStyle: {
                            color: '#D10E00',
                            width: 1,
                            opacity: 1
                        },
                        data: graphData,
                        z: 20
                    },
                    {
                        type: 'heatmap',
                        coordinateSystem: 'calendar',
                        data: getVirtulData(2022)
                    }
                ]
            }
            chartUni.setOption(option)
        },
        echartsBin() {
            var chartBin = this.$echarts.init(document.getElementById('chartsBin'))
            const graphData = [
                ['2022-03-01', 270],
                ['2022-03-05', 270],
                ['2022-03-06', 279],
                ['2022-03-15', 877],
                ['2022-03-22', 271],
                ['2022-03-29', 471]
            ]
            const links = graphData.map(function(item, idx) {
                return {
                    source: idx,
                    target: idx + 1
                }
            })
            function getVirtulData(year) {
                year = year || '2022'
                var date = +echarts.number.parseDate(year + '-01-01')
                var end = +echarts.number.parseDate(+year + 1 + '-01-01')
                var dayTime = 3600 * 24 * 1000
                var data = []
                for (var time = date; time < end; time += dayTime) {
                    data.push([
                        echarts.format.formatTime('yyyy-MM-dd', time),
                        Math.floor(Math.random() * 1000)
                    ])
                }
                return data
            }
            links.pop()
            // 配置图表
            var option = {
                tooltip: {},
                calendar: {
                    top: 'middle',
                    left: 'center',
                    orient: 'vertical',
                    cellSize: 40,
                    yearLabel: {
                        margin: 50,
                        fontSize: 30
                    },
                    dayLabel: {
                        firstDay: 0,
                        nameMap: 'cn'
                    },
                    monthLabel: {
                        nameMap: 'cn',
                        margin: 15,
                        fontSize: 20,
                        color: '#999'
                    },
                    range: ['2022-03']
                },
                visualMap: {
                    min: 0,
                    max: 1000,
                    type: 'piecewise',
                    left: 'center',
                    bottom: 20,
                    inRange: {
                        color: ['#5291FF', '#C7DBFF']
                    },
                    seriesIndex: [1],
                    orient: 'horizontal'
                },
                series: [
                    {
                        type: 'graph',
                        edgeSymbol: ['none', 'arrow'],
                        coordinateSystem: 'calendar',
                        links: links,
                        symbolSize: 15,
                        calendarIndex: 0,
                        itemStyle: {
                            color: 'yellow',
                            shadowBlur: 9,
                            shadowOffsetX: 1.5,
                            shadowOffsetY: 3,
                            shadowColor: '#555'
                        },
                        lineStyle: {
                            color: '#D10E00',
                            width: 1,
                            opacity: 1
                        },
                        data: graphData,
                        z: 20
                    },
                    {
                        type: 'heatmap',
                        coordinateSystem: 'calendar',
                        data: getVirtulData(2022)
                    }
                ]
            }
            chartBin.setOption(option)
        },
        echartsTer() {
            var chartTer = this.$echarts.init(document.getElementById('chartsTer'))
            var app = {}
            var option
            const posList = [
                'left',
                'right',
                'top',
                'bottom',
                'inside',
                'insideTop',
                'insideLeft',
                'insideRight',
                'insideBottom',
                'insideTopLeft',
                'insideTopRight',
                'insideBottomLeft',
                'insideBottomRight'
            ]
            app.configParameters = {
                rotate: {
                    min: -90,
                    max: 90
                },
                align: {
                    options: {
                        left: 'left',
                        center: 'center',
                        right: 'right'
                    }
                },
                verticalAlign: {
                    options: {
                        top: 'top',
                        middle: 'middle',
                        bottom: 'bottom'
                    }
                },
                position: {
                    options: posList.reduce(function(map, pos) {
                        map[pos] = pos
                        return map
                    }, {})
                },
                distance: {
                    min: 0,
                    max: 100
                }
            }
            app.config = {
                rotate: 45,
                align: 'left',
                verticalAlign: 'middle',
                position: 'insideBottom',
                distance: 50,
                onChange: function() {
                    const labelOption = {
                        rotate: app.config.rotate,
                        align: app.config.align,
                        verticalAlign: app.config.verticalAlign,
                        position: app.config.position,
                        distance: app.config.distance
                    }
                    chartTer.setOption({
                        series: [
                            {
                                label: labelOption
                            },
                            {
                                label: labelOption
                            },
                            {
                                label: labelOption
                            },
                            {
                                label: labelOption
                            }
                        ]
                    })
                }
            }
            const labelOption = {
                show: true,
                position: app.config.position,
                distance: app.config.distance,
                align: app.config.align,
                verticalAlign: app.config.verticalAlign,
                rotate: app.config.rotate,
                formatter: '{c}  {name|{a}}',
                fontSize: 10,
                rich: {
                    name: {}
                }
            }
            // 配置图表
            option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                legend: {
                    data: ['正常', '缺勤', '补签', '未下班打卡']
                },
                toolbox: {
                    show: true,
                    orient: 'vertical',
                    left: 'right',
                    top: 'center',
                    feature: {
                        mark: { show: true },
                        dataView: { show: true, readOnly: true },
                        magicType: { show: true, type: ['line', 'bar', 'stack'] },
                        restore: { show: true },
                        saveAsImage: { show: false }
                    }
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: { show: false },
                        data: ['四天前', '大前天', '前天', '昨天', '今天']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '正常',
                        type: 'bar',
                        barGap: 0,
                        label: labelOption,
                        emphasis: {
                            focus: 'series'
                        },
                        data: [15, 9, 20, 15, 20]
                    },
                    {
                        name: '缺勤',
                        type: 'bar',
                        label: labelOption,
                        emphasis: {
                            focus: 'series'
                        },
                        data: [2, 2, 9, 4, 5]
                    },
                    {
                        name: '补签',
                        type: 'bar',
                        label: labelOption,
                        emphasis: {
                            focus: 'series'
                        },
                        data: [10, 20, 21, 14, 19]
                    },
                    {
                        name: '未下班打卡',
                        type: 'bar',
                        label: labelOption,
                        emphasis: {
                            focus: 'series'
                        },
                        data: [8, 7, 11, 9, 4]
                    }
                ]
            }
            chartTer.setOption(option)
        }
    }
}
</script>

