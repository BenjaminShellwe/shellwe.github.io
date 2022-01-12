<template>
    <div>
        <page-header title="帮助说明">
            <template #content>
                <div class="inLine">
                    <p @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    访问此次说明您在使用本系统遇到了问题,或者你在寻找使用手册
                </div>
            </template>
        </page-header>
        <page-main>
            <span>
                本帮助页面将会提供从部署到配置运行详细介绍本系统,
                代码同时同步到GitHub,但本页面不提供GitHub连接,
                有需要请联系
                <el-button type="text" class="btn" data-clipboard-text="haotian19981998@gmail.com" @click="centerDialogVisible = true">
                    shellwe
                </el-button>
                获取完整代码
            </span>
            <el-dialog
                title="来自shellwe的提示"
                :visible.sync="centerDialogVisible"
                width="30%"
                center
            >
                <span class="cen">是否要复制shellwe的Gmail</span>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="centerDialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="copy">确 定</el-button>
                </span>
            </el-dialog>
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
import PageHeader from '@/components/PageHeader'

export default {
    name: 'Index',
    components: {PageMain, PageHeader},
    data() {
        return {
            centerDialogVisible: false
        }
    },
    methods: {
        back() {
            history.go(-1)
        },
        // https://blog.csdn.net/weixin_43299180/article/details/112473038
        copy() {
            this.$data.centerDialogVisible = false
            let clipboard = new this.clipboard('.btn')
            if (clipboard.on('success', function() {
                console.log('复制成功')
            })) {
                this.$notify({
                    title: '成功',
                    message: '已成功复制',
                    type: 'success'
                })
            } else {
                clipboard.on('error', function() {
                    console.log('复制失败')
                })
                this.$notify.error({
                    title: '错误',
                    message: '这是一条错误的提示消息'
                })
            }
        }
    }
}
</script>

<style>
.hover {
    cursor: pointer;
}
.cen {
    text-align: center;
}
</style>
