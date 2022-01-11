<template>
    <div>
        <page-header title="">
            <template #content>
                <div class="inLine">
                    <p @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为即时站内聊天室
                </div>
            </template>
        </page-header>
        <page-main>
            <div class="container">
                <h2 class="text-center">即时通讯</h2>
                <p>昵称:{{ $store.state.user.account }}</p>
                <form action="" class="form-horizontal">
                    <div class="form-group">
                        <div class="chat-list form-control">
                            <p v-for="item in chatList" :key="item">{{ item.$store.state.user.account }} : {{ item.content }}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="inLine">
                            <el-input v-model="content" clearable type="text" class="form-control" placeholder="请输入内容" />
                        </div>
                        <el-button type="success" icon="el-icon-check" round class="inLine" @click.prevent="send" @click="dialogVisible = true">发送</el-button>
                        <el-dialog
                            title="操作提示"
                            :visible.sync="dialogVisible"
                            width="30%"
                        >
                            <span>开发中 此操作暂时拒绝</span>
                            <span slot="footer" class="dialog-footer">
                                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
                            </span>
                        </el-dialog>
                    </div>
                </form>
            </div>
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
export default {
    el: 'container',
    name: 'Chat',
    components: {PageMain},
    data() {
        return {
            dialogVisible: false,
            ws: null,
            nickName: '',
            chatList: [],
            content: ''
        }
    },
    mounted: function() {
        this.nickName = this.$store.state.user.account
        this.ws = new WebSocket('ws://localhost:3000')
        this.ws.onopen = function() {
            console.log('连接成功')
        }
        const _this = this
        this.ws.onmessage = function(ev) {
            const item = JSON.parse(ev.data)
            _this.chatList.push(item)
        }
    },
    methods: {
        send() {
            const data = {
                nickName: this.nickName,
                content: this.content
            }
            // 将信息发送到后端
            this.ws.send(JSON.stringify(data))
        },
        back() {
            history.go(-1)
        }
    }
}
</script>

<style>
.inLine {
    display: inline-block;
}
</style>
