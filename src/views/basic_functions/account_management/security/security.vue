<template>
    <div>
        <page-header title="安全中心">
            <template #content>
                <div class="inLine">
                    <p @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为账户的安全设置 此页面设置为管理员可见
                </div>
            </template>
        </page-header>
        <page-main>
            <el-card>
                <div>
                    <el-carousel indicator-position="outside" :height="dataHeight">
                        <el-carousel-item v-for="item in pageCarouselValue" :key="item">
                            <h3 class="pageText">提示: {{ item }}</h3>
                        </el-carousel-item>
                    </el-carousel>
                </div>
                <div>
                    <el-row>
                        <el-col :span="6">
                            <el-card style="margin: 0 10px 10px 0; height: 250px;" shadow="hover" body-style="padding: 2px">
                                <div class="Echarts">
                                    <div id="chartsUni" style="width: 350px; height: 350px; padding: 0; margin: 0;" />
                                </div>
                            </el-card>
                        </el-col>
                        <el-col :span="18">
                            <el-row>
                                <el-col :span="12">
                                    <el-card class="pageCard" shadow="hover">
                                        <el-row>
                                            <el-col :span="16">
                                                <el-input v-model="pageInputValue" type="number" placeholder="仅能输入0-1的零后两位小数" />
                                                <el-card class="pageCard" shadow="hover">
                                                    <span>存在问题可能造成安全风险  <el-button type="warning" size="mini" plain>点击处理</el-button></span>
                                                </el-card>
                                            </el-col>
                                            <el-col :span="8">
                                                <el-button @click="handleChartsChange()">提交</el-button>
                                            </el-col>
                                        </el-row>
                                    </el-card>
                                </el-col>
                                <el-col :span="12">

                                </el-col>
                            </el-row>
                        </el-col>
                    </el-row>
                    <el-row />
                    <el-row>
                        <el-card class="pageCardRol" style="height: 260px;" shadow="hover">
                            安全风险
                            <el-row>
                                <el-col :span="8">
                                    <div class="grid-content">
                                        <div class="Echarts">
                                            <div id="chartsBin" style="width: 500px; height: 250px;" />
                                        </div>
                                    </div>
                                </el-col>
                                <el-col :span="8">
                                    <div class="grid-content">
                                        <div class="Echarts">
                                            <div id="chartsTer" style="width: 500px; height: 250px;" />
                                        </div>
                                    </div>
                                </el-col>
                                <el-col :span="4">
                                    <div class="grid-content">
                                        <sapn style="font-weight: bold;">基本检测</sapn><br>
                                        <span>检查后台数据存取情况</span><br>
                                        <el-button size="mini" plain>立即检查</el-button>
                                    </div>
                                </el-col>
                                <el-col :span="4">
                                    <sapn style="font-weight: bold;">操作监控</sapn><br>
                                    <span>监控后台操作情况</span><br>
                                    <el-button size="mini" plain>立即检查</el-button>
                                </el-col>
                            </el-row>
                        </el-card>
                    </el-row>
                </div>
                <div>
                    <el-row>
                        <el-col>
                            <el-card class="pageCard" shadow="hover">

                            </el-card>
                            <el-card shadow="hover">
                                {{ pageInputValue }}
                            </el-card>
                        </el-col>
                    </el-row>
                </div>
            </el-card>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
var chartUni, chartBin, chartTer
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    props: {
        dataHeight: {
            type: String,
            default: '50px'
        }
    },
    data() {
        return {
            pageCarouselValue: [
                '安全值被修改会有显示',
                '根据人员进行权限分配',
                '完成操作需要重新登录'
            ],
            pageInputValue: ''
        }
    },
    computed: {
    },
    mounted() {
        this.echartsUni()
    },
    methods: {
        back() {
            history.go(-1)
        },
        change() {
            this.$forceUpdate()
        },
        echartsUni() {
            chartUni = this.$echarts.init(document.getElementById('chartsUni'))
            // 配置图表
            var option = {
                series: [
                    {
                        type: 'gauge',
                        startAngle: 180,
                        endAngle: 0,
                        min: 0,
                        max: 1,
                        splitNumber: 8,
                        axisLine: {
                            lineStyle: {
                                width: 6,
                                color: [
                                    [0.25, '#FF6E76'],
                                    [0.5, '#FDDD60'],
                                    [0.75, '#58D9F9'],
                                    [1, '#7CFFB2']
                                ]
                            }
                        },
                        pointer: {
                            icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
                            length: '12%',
                            width: 20,
                            offsetCenter: [0, '-60%'],
                            itemStyle: {
                                color: 'auto'
                            }
                        },
                        axisTick: {
                            length: 12,
                            lineStyle: {
                                color: 'auto',
                                width: 2
                            }
                        },
                        splitLine: {
                            length: 20,
                            lineStyle: {
                                color: 'auto',
                                width: 5
                            }
                        },
                        axisLabel: {
                            color: '#464646',
                            fontSize: 20,
                            distance: -60,
                            formatter: function(value) {
                                if (value === 0.875) {
                                    return 'A'
                                } else if (value === 0.625) {
                                    return 'B'
                                } else if (value === 0.375) {
                                    return 'C'
                                } else if (value === 0.125) {
                                    return 'D'
                                }
                                return ''
                            }
                        },
                        title: {
                            offsetCenter: [0, '-20%'],
                            fontSize: 30
                        },
                        detail: {
                            fontSize: 35,
                            offsetCenter: [0, '0%'],
                            valueAnimation: true,
                            formatter: function(value) {
                                if (value >= 0 && value <= 0.25) {
                                    return '\n' + Math.round(value * 100) + '\n处于高危'
                                }
                                if (value >= 0.25 && value <= 0.5) {
                                    return '\n' + Math.round(value * 100) + '\n处于中危'
                                }
                                if (value >= 0.5 && value <= 0.75) {
                                    return '\n' + Math.round(value * 100) + '\n暂时低危'
                                }
                                if (value >= 0.75 && value < 1) {
                                    return '\n' + Math.round(value * 100) + '\n基本安全'
                                }
                                if (value == 1) {
                                    return '\n' + Math.round(value * 100) + '\n暂无异常'
                                } if (value == '' || value == 'undefined' || value == null || isNaN) {
                                    return '\n未检测到数据'
                                } else {
                                    return '\n数据异常' + value
                                }
                            },
                            color: 'auto'
                        },
                        data: [
                            {
                                value: null,
                                name: '安全值'
                            }
                        ]
                    }
                ],
                legend: {
                    show: false
                }
            }
            chartUni.setOption(option)
            function dateString(i) {
                let date = new Date()
                date.setDate(date.getDate() + i)
                let m = date.getMonth() + 1 < 10 ? (date.getMonth() + 1) : date.getMonth() + 1
                console.log(m)
                let d = date.getDate() < 10 ? date.getDate() : date.getDate()
                console.log(d)
                return  (m) + '月' + (d) + '日'
            }
            chartBin = this.$echarts.init(document.getElementById('chartsBin'))
            var optionBin = {
                title: {
                    text: '待处理告警示'
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: [dateString(-6), dateString(-5), dateString(-4), dateString(-3), dateString(-2), dateString(-1), dateString(0) ]
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: [5, 5, 8, 15, 1, 1, 0],
                        type: 'line',
                        areaStyle: {},
                        color: ['#ff9650']
                    }
                ]
            }
            chartBin.setOption(optionBin)
            chartTer = this.$echarts.init(document.getElementById('chartsTer'))
            var optionTer = {
                title: {
                    text: '待修复缺漏洞'
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: [dateString(-6), dateString(-5), dateString(-4), dateString(-3), dateString(-2), dateString(-1), dateString(0) ]
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: [2, 3, 3, 2, 1, 1, 0],
                        type: 'line',
                        areaStyle: {},
                        color: ['#50dfff']
                    }
                ]
            }
            chartTer.setOption(optionTer)
        },
        handleChartsChange() {
            let inputValue = this.pageInputValue
            chartUni.setOption({
                series: [
                    {
                        data: [
                            {
                                value: inputValue,
                                name: '安全值已被修改'
                            }
                        ]
                    }
                ]
            })
            console.log(inputValue)
        }
    }
}
</script>
<style>
.pageText {
    margin: 0 auto;
    text-align: center;
}
.pageCard {
    margin-bottom: 15px;
    margin-right: 10px;
}
.pageCardRol {
    margin-bottom: 15px;
    margin-right: 10px;
    height: 140px;
}
.carousel .item {
    height: 20px;
    background-color: #777;
}
.carousel-inner > .item > img {
    position: absolute;
    top: 0;
    left: 0;
    min-width: 100%;
    height: 200px;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 15px;
    opacity: 0.75;
    line-height: 50px;
    height: 50px;
    margin: 0;
}
.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}
</style>
