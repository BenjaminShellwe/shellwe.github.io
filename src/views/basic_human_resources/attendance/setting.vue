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
                            <el-col>
                                <el-card shadow="hover">
                                    <div slot="header">
                                        <span>考勤记录 (点击右边进行操作)</span>
                                        <el-button style="float: right; padding: 3px 0;" type="text">操作</el-button>
                                    </div>
                                    <el-row>
                                        <el-col :span="15">
                                            <div id="chartsAbnormal" class="Echarts" style="width: 850px; height: 420px;" />
                                        </el-col>
                                        <el-col :span="9">
                                            <div id="chartsCompare" class="Echarts" style="width: 490px; height: 420px;" />
                                        </el-col>
                                    </el-row>
                                </el-card>
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
                                    placeholder="输入ID搜索"
                                />
                            </template>
                            <template>
                                <el-button-group>
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
                                </el-button-group>
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
        this.echartsAbnormal()
        this.echartsCompare()
        this.echartsTer()
    },
    methods: {
        back() {
            history.go(-1)
        },
        echartsAbnormal() {
            var chartAbnormal = this.$echarts.init(document.getElementById('chartsAbnormal'))
            // 配置图表
            const hours = [
                '12a', '1a', '2a', '3a', '4a', '5a', '6a',
                '7a', '8a', '9a', '10a', '11a',
                '12p', '1p', '2p', '3p', '4p', '5p',
                '6p', '7p', '8p', '9p', '10p', '11p'
            ]
            // prettier-ignore
            const days = [
                'Saturday', 'Friday', 'Thursday',
                'Wednesday', 'Tuesday', 'Monday', 'Sunday'
            ]
            // prettier-ignore
            const data = [[0, 0, 5], [0, 1, 1], [0, 2, 0], [0, 3, 0], [0, 4, 0], [0, 5, 0], [0, 6, 0], [0, 7, 0], [0, 8, 0], [0, 9, 0], [0, 10, 0], [0, 11, 2], [0, 12, 4], [0, 13, 1], [0, 14, 1], [0, 15, 3], [0, 16, 4], [0, 17, 6], [0, 18, 4], [0, 19, 4], [0, 20, 3], [0, 21, 3], [0, 22, 2], [0, 23, 5], [1, 0, 7], [1, 1, 0], [1, 2, 0], [1, 3, 0], [1, 4, 0], [1, 5, 0], [1, 6, 0], [1, 7, 0], [1, 8, 0], [1, 9, 0], [1, 10, 5], [1, 11, 2], [1, 12, 2], [1, 13, 6], [1, 14, 9], [1, 15, 11], [1, 16, 6], [1, 17, 7], [1, 18, 8], [1, 19, 12], [1, 20, 5], [1, 21, 5], [1, 22, 7], [1, 23, 2], [2, 0, 1], [2, 1, 1], [2, 2, 0], [2, 3, 0], [2, 4, 0], [2, 5, 0], [2, 6, 0], [2, 7, 0], [2, 8, 0], [2, 9, 0], [2, 10, 3], [2, 11, 2], [2, 12, 1], [2, 13, 9], [2, 14, 8], [2, 15, 10], [2, 16, 6], [2, 17, 5], [2, 18, 5], [2, 19, 5], [2, 20, 7], [2, 21, 4], [2, 22, 2], [2, 23, 4], [3, 0, 7], [3, 1, 3], [3, 2, 0], [3, 3, 0], [3, 4, 0], [3, 5, 0], [3, 6, 0], [3, 7, 0], [3, 8, 1], [3, 9, 0], [3, 10, 5], [3, 11, 4], [3, 12, 7], [3, 13, 14], [3, 14, 13], [3, 15, 12], [3, 16, 9], [3, 17, 5], [3, 18, 5], [3, 19, 10], [3, 20, 6], [3, 21, 4], [3, 22, 4], [3, 23, 1], [4, 0, 1], [4, 1, 3], [4, 2, 0], [4, 3, 0], [4, 4, 0], [4, 5, 1], [4, 6, 0], [4, 7, 0], [4, 8, 0], [4, 9, 2], [4, 10, 4], [4, 11, 4], [4, 12, 2], [4, 13, 4], [4, 14, 4], [4, 15, 14], [4, 16, 12], [4, 17, 1], [4, 18, 8], [4, 19, 5], [4, 20, 3], [4, 21, 7], [4, 22, 3], [4, 23, 0], [5, 0, 2], [5, 1, 1], [5, 2, 0], [5, 3, 3], [5, 4, 0], [5, 5, 0], [5, 6, 0], [5, 7, 0], [5, 8, 2], [5, 9, 0], [5, 10, 4], [5, 11, 1], [5, 12, 5], [5, 13, 10], [5, 14, 5], [5, 15, 7], [5, 16, 11], [5, 17, 6], [5, 18, 0], [5, 19, 5], [5, 20, 3], [5, 21, 4], [5, 22, 2], [5, 23, 0], [6, 0, 1], [6, 1, 0], [6, 2, 0], [6, 3, 0], [6, 4, 0], [6, 5, 0], [6, 6, 0], [6, 7, 0], [6, 8, 0], [6, 9, 0], [6, 10, 1], [6, 11, 0], [6, 12, 2], [6, 13, 1], [6, 14, 3], [6, 15, 4], [6, 16, 0], [6, 17, 0], [6, 18, 0], [6, 19, 0], [6, 20, 1], [6, 21, 2], [6, 22, 2], [6, 23, 6]]
                .map(function(item) {
                    return [item[1], item[0], item[2] || '-']
                })
            var option = {
                title: {
                    text: '考勤异常记录',
                    subtext: '颜色越深异常人数越多'
                },
                tooltip: {
                    position: 'top'
                },
                grid: {
                    height: '50%',
                    top: '10%'
                },
                xAxis: {
                    type: 'category',
                    data: hours,
                    splitArea: {
                        show: true
                    }
                },
                yAxis: {
                    type: 'category',
                    data: days,
                    splitArea: {
                        show: true
                    }
                },
                visualMap: {
                    min: 0,
                    max: 10,
                    calculable: true,
                    orient: 'horizontal',
                    left: 'center',
                    bottom: '15%'
                },
                series: [
                    {
                        name: 'Punch Card',
                        type: 'heatmap',
                        data: data,
                        label: {
                            show: true
                        },
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            }
            chartAbnormal.setOption(option)
        },
        echartsCompare() {
            let chartCompare = this.$echarts.init(document.getElementById('chartsCompare'))
            let option = {
                title: {
                    text: '考勤丁格尔图',
                    subtext: 'Data',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                legend: {
                    left: 'center',
                    top: 'bottom',
                    data: [
                        'rose1',
                        'rose2',
                        'rose3',
                        'rose4',
                        'rose5',
                        'rose6',
                        'rose7',
                        'rose8'
                    ]
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: { show: true },
                        dataView: { show: true, readOnly: false },
                        restore: { show: true },
                        saveAsImage: { show: true }
                    }
                },
                series: [
                    {
                        name: 'Radius Mode',
                        type: 'pie',
                        radius: [20, 130],
                        center: ['50%', '50%'],
                        roseType: 'radius',
                        itemStyle: {
                            borderRadius: 8
                        },
                        label: {
                            show: false
                        },
                        emphasis: {
                            label: {
                                show: true
                            }
                        },
                        data: [
                            { value: 40, name: 'rose 1' },
                            { value: 33, name: 'rose 2' },
                            { value: 28, name: 'rose 3' },
                            { value: 22, name: 'rose 4' },
                            { value: 20, name: 'rose 5' },
                            { value: 15, name: 'rose 6' },
                            { value: 12, name: 'rose 7' },
                            { value: 10, name: 'rose 8' }
                        ]
                    }
                ]
            }
            chartCompare.setOption(option)
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

