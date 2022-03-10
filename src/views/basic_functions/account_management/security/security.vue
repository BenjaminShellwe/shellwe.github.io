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
        <!--  权限控制     -->
        <page-main title="权限控制">
            <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                <div slot="header" class="clearfix">
                    <span>权限控制 开发中 (点击右边进行操作)</span>
                    <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                </div>
                <el-row style="margin: 3px 0;">
                    <!--企业高级-->
                    <el-table
                        :data="pagePermissionControl"
                        border
                        style="width: 100%;">
                        <el-table-column
                            v-for="(item, index) in pagePermissionControlEHeader"
                            :key="index"
                            :prop="index"
                            :label="item"
                            :fit="true"
                            :width="item.width"
                        />
                        <el-table-column
                            fixed="right"
                            label="操作"
                            width="90"
                        >
                            <template>
                                <el-button-group>
                                    <el-button type="text" size="mini" style="margin: 0 2px;">编辑</el-button>
                                    <el-button type="text" size="mini" style="margin: 0 2px;">移除</el-button>
                                </el-button-group>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-row>
                <el-row style="margin: 3px 0;">
                    <!--企业基础-->
                    <el-table
                        :data="pagePermissionControl"
                        border
                        style="width: 100%;">
                        <el-table-column
                            v-for="(item, index) in pagePermissionControlBHeader"
                            :key="index"
                            :prop="index"
                            :label="item"
                            :fit="true"
                            :width="item.width"
                        />
                        <el-table-column
                            fixed="right"
                            label="操作"
                            width="90"
                        >
                            <template>
                                <el-button-group>
                                    <el-button type="text" size="mini" style="margin: 0 2px;">编辑</el-button>
                                    <el-button type="text" size="mini" style="margin: 0 2px;">移除</el-button>
                                </el-button-group>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-row>
                <el-row style="margin: 3px 0;">
                    <!--企业个人-->
                    <el-table
                        :data="pagePermissionControl"
                        border
                        style="width: 100%;">
                        <el-table-column
                            v-for="(item, index) in pagePermissionControlPHeader"
                            :key="index"
                            :prop="index"
                            :label="item"
                            :fit="true"
                            :width="item.width"
                        />
                        <el-table-column
                            fixed="right"
                            label="操作"
                            width="90"
                        >
                            <template>
                                <el-button-group>
                                    <el-button type="text" size="mini" style="margin: 0 2px;">编辑</el-button>
                                    <el-button type="text" size="mini" style="margin: 0 2px;">移除</el-button>
                                </el-button-group>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-row>
            </el-card>
            <el-card shadow="hover">
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
                                                <el-button @click="handleChartsChange()">提交</el-button>
                                            </el-col>
                                            <el-col :span="8">

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
            pagePermissionControl: [
                {
                    role: '未检测到或数据受保护',
                    enterprisePermission: '未检测到或数据受保护',
                    enterpriseAdd: '未检测到或数据受保护',
                    enterpriseAlter: '未检测到或数据受保护',
                    enterpriseQuery: '未检测到或数据受保护',
                    enterpriseDelete: '未检测到或数据受保护',
                    basicPermission: '未检测到或数据受保护',
                    basicAdd: '未检测到或数据受保护',
                    basicAlter: '未检测到或数据受保护',
                    basicQuery: '未检测到或数据受保护',
                    basicDelete: '未检测到或数据受保护',
                    personalPermission: '未检测到或数据受保护',
                    personalAdd: '未检测到或数据受保护',
                    personalAlter: '未检测到或数据受保护',
                    personalQuery: '未检测到或数据受保护',
                    personalDelete: '未检测到或数据受保护',
                    status: '未检测到或数据受保护'
                }
            ],
            pagePermissionControlEHeader: {
                role: '角色',
                enterprisePermission: '企业高级权限',
                enterpriseAdd: '高级增添',
                enterpriseAlter: '高级修改',
                enterpriseQuery: '高级查询',
                enterpriseDelete: '高级删除',
                status: '状态'
            },
            pagePermissionControlBHeader: {
                role: '角色',
                basicPermission: '企业基础权限',
                basicAdd: '基础增添',
                basicAlter: '基础修改',
                basicQuery: '基础查询',
                basicDelete: '基础删除',
                status: '状态'
            },
            pagePermissionControlPHeader: {
                role: '角色',
                personalPermission: '个人账户权限',
                personalAdd: '个人增加',
                personalAlter: '个人修改',
                personalQuery: '个人查询',
                personalDelete: '个人删除',
                status: '状态'
            },
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
