<template>
    <div>
        <page-header title="在线助理">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为系统在线助理 本页面还在设计中 在线助力由人事与技术部门管理
                </div>
            </template>
        </page-header>
        <page-main>
            <el-row :gutter="10" type="flex" class="row-bg el-row-two" justify="space-between">
                <el-col :span="12">
                    <div class="grid-content">
                        <el-card class="grid-content" style="height: 480px;" shadow="hover">
                            <div class="chat-box">
                                <header>在线助理 (在线:{{ count }}人)</header>
                                <div ref="msg-box" class="msg-box">
                                    <div
                                        v-for="(i,index) in list"
                                        :key="index"
                                        class="msg"
                                        :style="i.userId == userId?'flex-direction:row-reverse':''"
                                    >
                                        <div class="user-head">
                                            <img :src="i.avatar" height="30" width="30" :title="i.username">
                                        </div>
                                        <div class="user-msg">
                                            <span :style="i.userId == userId?' float: right;':''" :class="i.userId == userId?'right':'left'">{{ i.content }}</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="input-box">
                                    <input ref="sendMsg" v-model="contentText" type="text" @keyup.enter="sendText()">
                                    <div class="btn" :class="{['btn-active']:contentText}" @click="sendText()">发送</div>
                                </div>
                            </div>
                        </el-card>
                    </div>
                </el-col>
                <el-col :span="12">
                    <div class="grid-content ">
                        <el-card shadow="hover">
                            <el-collapse v-model="pageCollapseValue" accordion>
                                <el-collapse-item title="在线助理说明" name="1">
                                    <div>一般为机器人在线提供帮助</div>
                                    <div>也可以呼叫人工</div>
                                </el-collapse-item>
                                <el-collapse-item title="提供问题反馈" name="2">
                                    <div>问题反馈,助理将会记录您使用过程中遇到的问题向后台工作人员反馈</div>
                                    <div>页面问题反馈,助理将会收集您在工作过程中遇到的问题</div>
                                </el-collapse-item>
                                <el-collapse-item title="预留1" name="3">
                                    <div>预留一</div>
                                </el-collapse-item>
                                <el-collapse-item title="预留2" name="4">
                                    <div>预留二</div>
                                </el-collapse-item>
                            </el-collapse>
                        </el-card>
                    </div>
                </el-col>
            </el-row>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Online',
    components: {PageMain, PageHeader},
    data() {
        return {
            pageCollapseValue: ''
        }
    },
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>
<style lang="scss" scoped>
.hover {
    cursor: pointer;
}
.chat-box {
    margin: 0 auto;
    background: #fafafa;
    position: absolute;
    height: 92%;
    width: 80%;
    max-width: 710px;
    header {
        width: 100%;
        height: 3rem;
        background: #409eff;
        max-width: 710px;
        display: flex;
        justify-content: center;
        align-items: center;
        font-weight: bold;
        color: white;
        font-size: 1rem;
    }
    .msg-box {
        position: absolute;
        height: calc(100% - 6.5rem);
        width: 100%;
        margin-top: 3rem;
        overflow-y: scroll;
        .msg {
            width: 95%;
            min-height: 2.5rem;
            margin: 1rem 0.5rem;
            position: relative;
            display: flex;
            justify-content: flex-start !important;
            .user-head {
                min-width: 2.5rem;
                width: 20%;
                width: 2.5rem;
                height: 2.5rem;
                border-radius: 50%;
                background: #f1f1f1;
                display: flex;
                justify-content: center;
                align-items: center;
                .head {
                    width: 1.2rem;
                    height: 1.2rem;
                }
            }
            .user-msg {
                width: 80%;
                // position: absolute;
                word-break: break-all;
                position: relative;
                z-index: 5;
                span {
                    display: inline-block;
                    padding: 0.5rem 0.7rem;
                    border-radius: 0.5rem;
                    margin-top: 0.2rem;
                    font-size: 0.88rem;
                }
                .left {
                    background: white;
                    animation: toLeft 0.5s ease both 1;
                }
                .right {
                    background: #53a8ff;
                    color: white;
                    animation: toright 0.5s ease both 1;
                }
                @keyframes toLeft {
                    0% {
                        opacity: 0;
                        transform: translateX(-10px);
                    }
                    100% {
                        opacity: 1;
                        transform: translateX(0);
                    }
                }
                @keyframes toright {
                    0% {
                        opacity: 0;
                        transform: translateX(10px);
                    }
                    100% {
                        opacity: 1;
                        transform: translateX(0);
                    }
                }
            }
        }
    }
    .input-box {
        padding: 0 0.5rem;
        position: absolute;
        bottom: 0;
        width: 100%;
        height: 3.5rem;
        background: #fafafa;
        box-shadow: 0 0 5px #ccc;
        display: flex;
        justify-content: space-between;
        align-items: center;
        input {
            height: 2.3rem;
            display: inline-block;
            width: 100%;
            padding: 0.5rem;
            border: none;
            border-radius: 0.2rem;
            font-size: 0.88rem;
        }
        .btn {
            height: 2.3rem;
            min-width: 4rem;
            background: #e0e0e0;
            padding: 0.5rem;
            font-size: 0.88rem;
            color: white;
            text-align: center;
            border-radius: 0.2rem;
            margin-left: 0.5rem;
            transition: 0.5s;
        }
        .btn-active {
            background: #409eff;
        }
    }
}
</style>
