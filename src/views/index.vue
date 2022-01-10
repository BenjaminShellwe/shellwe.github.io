<template>
    <div>
        <page-header title="">
            <template #content>
                <div>
                    <div style="margin-bottom: 5px;">毕业设计开发</div>
                </div>
            </template>
            <!--            <el-button-group style="margin-right: 10px;">-->
            <!--                <el-button type="success" plain @click="open(` `)">el按钮1</el-button>-->
            <!--                <el-button type="primary" plain @click="open(` `)">el按钮2</el-button>-->
            <!--            </el-button-group>-->
        </page-header>
        <el-row :gutter="20" style="margin: 0 10px;">
            <el-col :lg="8">
                <page-main title="基本信息" style="margin: 0 0 0 0;">
                    <div class="fa-info">
                        <img style="width: 150px;">
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
                        <div :title="tips.dictionary" class="icon-box icon-box-2" @click="onIconClick('dictionary','')">
                            <i class="el-icon-notebook-2" />
                            <div class="title">个人字典</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.chat" class="icon-box icon-box-3" @click="onIconClick('chat','')">
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
                        <div :title="tips.message" class="icon-box icon-box-5" @click="onIconClick('message','')">
                            <i class="el-icon-message" />
                            <div class="title">站内通知</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.help" class="icon-box icon-box-4" @click="onIconClick('help','')">
                            <i class="el-icon-help" />
                            <div class="title">快速帮助</div>
                        </div>
                    </el-col>
                </el-row>
                <Glide />
                <page-main title="卡片2 题目" style="margin: 0;">
                    <div class="question">
                        <ol class="answer">
                            <li><span>次标题1</span>内容</li>
                            <li><span>次标题2</span></li>
                            <li><span>次标题3</span></li>
                            <li><span>次标题4</span></li>
                            <li><span>次标题5</span></li>
                        </ol>
                    </div>
                </page-main>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import router from '@/router'

export default {

    data() {
        return {
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
    methods: {
        open(url) {
            window.open(url, 'top')
        },
        onIconClick(val, state) {
            function executeFunc(val) {
                if (val == 'information') {
                    router.go(1)
                } else {
                    console.log('Receiving an error  information')
                }
            }

            if (state !== true) {
                this.$message({
                    message: `clicking ${val}, is under construction`,
                    type: 'info'
                })
            } else {
                executeFunc(val)
            }
        },
        timeNow() {
            var h = new Date().getHours()
            var m = new Date().getMinutes()
            return h + ':' + m
        },
        onIconMouseover() {
            function $() {
            }
            $(function() {
                $('shellwe5').one('mouseover', function() {
                    console.log('Clicking action will refresh the page')
                    $(this).unbind()
                })
            })
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
        color: #fff;
    }
    &-1 {
        color: #ffc069;
        &:hover {
            background-color: #ffc069;
        }
    }
    &-2 {
        color: #b37feb;
        &:hover {
            background-color: #b37feb;
        }
    }
    &-3 {
        color: #95de64;
        &:hover {
            background-color: #95de64;
        }
    }
    &-4 {
        color: #ff85c0;
        &:hover {
            background-color: #ff85c0;
        }
    }
    &-5 {
        color: #ff9c6e;
        &:hover {
            background-color: #ff9c6e;
        }
    }
    &-6 {
        color: #282c34;
        &:hover {
            background-color: #282c34;
        }
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
