<template>
    <div>
        <page-header title="信息总览">
            <template #content>
                <div>
                    <div style="margin-bottom: 5px;">毕业设计开发</div>
                </div>
            </template>
        </page-header>
        <el-row :gutter="20" style="margin: 0 10px;">
            <el-col :lg="8">
                <page-main title="基本信息" style="margin: 0 0 0 0;">
                    <div class="fa-info">
                        <h1>Welcome!! {{ $store.state.user.account }}</h1>
                        <h4>Login time {{ timeNow() }} <br> There will be some welcome message</h4>
                        <el-table :data="diff" row-key="prop" size="mini" border stripe>
                            <el-table-column label="个人信息" align="center">
                                <template slot-scope="scope">
                                    <div v-for="(item, index) in scope.row.basic" :key="index">{{ item }}</div>
                                </template>
                            </el-table-column>
                            <el-table-column label="职位信息" align="center">
                                <template slot-scope="scope">
                                    <div v-for="(item, index) in scope.row.pro" :key="index">{{ item }}</div>
                                </template>
                            </el-table-column>
                        </el-table>
                    </div>
                    <br>
                    <!--                    <VEcharts />-->
                    <br>
                    <div class="Echarts">
                        <div id="chartsUni" style="width: 500px; height: 450px;" />
                    </div>
                </page-main>
            </el-col>
            <el-col :lg="16">
                <el-row :gutter="20" style="margin: 0 -10px 20px -10px;">
                    <el-col :md="4">
                        <div :title="tips.information" class="icon-box icon-box-1" @click="onIconClick('information',true)">
                            <i class="el-icon-info" />
                            <div class="title">信息总览</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.dictionary" class="icon-box icon-box-2" @click="onIconClick('dictionary',true)">
                            <i class="el-icon-notebook-2" />
                            <div class="title">个人字典</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.chat" class="icon-box icon-box-3" @click="onIconClick('chat',true)">
                            <i class="el-icon-chat-line-square" />
                            <div class="title">即时通信</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.extraFunction" class="icon-box icon-box-6" @click="onIconClick('extraFunction','')">
                            <i class="el-icon-camera" />
                            <div class="title">更多功能</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.message" class="icon-box icon-box-5" @click="onIconClick('message',true)">
                            <i class="el-icon-message" />
                            <div class="title">站内通知</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.help" class="icon-box icon-box-4" @click="onIconClick('help',true)">
                            <i class="el-icon-help" />
                            <div class="title">快速帮助</div>
                        </div>
                    </el-col>
                </el-row>
                <page-main>
                    <VCalendar />
                </page-main>

                <!--                <page-main title="卡片2 题目" style="margin: 0;">-->
                <!--                    <div class="question">-->
                <!--                        <ol class="answer">-->
                <!--                            <li><span>次标题1</span>内容</li>-->
                <!--                            <li><span>次标题2</span></li>-->
                <!--                            <li><span>次标题3</span></li>-->
                <!--                            <li><span>次标题4</span></li>-->
                <!--                            <li><span>次标题5</span></li>-->
                <!--                        </ol>-->
                <!--                    </div>-->
                <!--                </page-main>-->
            </el-col>
        </el-row>
    </div>
</template>

<script>
import router from '@/router'
import PageMain from '@/components/PageMain'
export default {
    name: 'IndexPage',
    components: {PageMain},
    data() {
        return {
            currentRole: 'dashboard',

            tips: {
                information: 'Click to refresh',
                dictionary: 'Set your personal data dictionary',
                chat: 'Start to chat with somebody',
                extraFunction: 'More action',
                message: 'Manage notification',
                help: 'Get online help'
            },
            location: {
                origin: location.origin
            },
            diff: [{
                basic: [
                    'context'
                ],
                pro: [
                    'context'
                ]
            }]
        }
    },
    mounted() {
        this.echartsUni()
    },
    methods: {
        open(url) {
            window.open(url, 'top')
        },
        onIconClick(val, state) {
            function executeFunc(val) {
                if (val == 'information') {
                    router.go(0)
                } if (val == 'dictionary') {
                    router.push({path: '/multilevel_menu_basic/management/personal_dic'})
                } if (val == 'chat') {
                    router.push({path: '/multilevel_menu_advanced/chat'})
                } if (val == 'message') {
                    router.push({path: '/multilevel_menu_advanced/message'})
                } if (val == 'help') {
                    router.push({path: '/multilevel_menu_basic/help/index'})
                } else {
                    console.log('Receiving an error!')
                }
            }

            if (state !== true) {
                this.$message({
                    message: `clicking ${val}, is under construction`,
                    type: 'info'
                })
            } else {
                executeFunc(val)
                console.log('执行')
            }
        },
        timeNow() {
            const h = new Date().getHours()
            const m = new Date().getMinutes()
            return h + ':' + m
        },
        echartsUni() {
            var chartUni = this.$echarts.init(document.getElementById('chartsUni'))
            // 配置图表
            var option = {
                tooltip: {},
                angleAxis: {
                    type: 'category'
                },
                radiusAxis: {},
                polar: {},
                series: [
                    {
                        type: 'pie',
                        color: [
                            '#ff0000',
                            '#ff9650',
                            '#f4fa3e',
                            '#467cff',
                            '#4eff43',
                            '#ff9f7f',
                            '#fb7293',
                            '#E062AE',
                            '#E690D1',
                            '#e7bcf3',
                            '#9d96f5',
                            '#8378EA',
                            '#96BFFF'
                        ],
                        data: [
                            {
                                value: 3,
                                name: '到期'
                            }, {
                                value: 4,
                                name: '紧急'
                            }, {
                                value: 2,
                                name: '待办'
                            }, {
                                value: 2,
                                name: '移交'
                            }, {
                                value: 2,
                                name: '完成'
                            }]
                    }
                ],
                roseType: 'area',
                legend: {
                    show: false
                }
            }
            chartUni.setOption(option)
        }
    }
}
</script>

<style lang="scss" scoped>
.fa-info {
    padding: 10px 0 0;
    text-align: center;
    h1 {
        margin: 10px auto 20px;
    }
}
.question {
    .answer {
        margin: 20px 0 0;
        padding-left: 20px;
        font-size: 14px;
        color: #aaa;
        li {
            margin-bottom: 10px;
            line-height: 1.5;
            &:last-child {
                margin-bottom: 0;
            }
        }
        span {
            color: #666;
            font-weight: bold;
        }
    }
}
.icon-box {
    padding: 20px;
    text-align: center;
    background-color: #fff;
    cursor: pointer;
    transition: 0.2s;
    &:hover {
        color: #a1a1a1;
    }
    i {
        font-size: 24px;
    }
    .title {
        margin-top: 5px;
        font-size: 14px;
    }
}
</style>
