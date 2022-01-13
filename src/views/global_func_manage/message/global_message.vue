<template>
    <div>
        <page-header title="通知设置">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页</div>
                    &nbsp;&nbsp;
                    <div class="inLine">此页面设置本管理系统通知推送</div>
                </div>
            </template>
        </page-header>
        <page-main title="系统通知设置">
            如无特殊权限，重要系统通知无法关闭推送
        </page-main>
        <page-main title="推送类型设置">
            <span>关闭系统自动类型管理 </span>
            <el-switch
                v-model="isShow"
                active-text="系统化"
                inactive-text="自定义"
                @click.native="changeIsNeedCaptcha(isShow)"
            />
            <div >
                <span v-show="isShow" id="collapsible0" style="color: red;">注意,选择系统化将会由后台管理通知权重</span>
                <span v-show="isHide" id="collapsible1" style="color: lightgreen;">注意,选择自定义将需要手动配置管理通知权重</span>
            </div>
            <el-dialog
                title="来自shellwe的警告"
                :visible.sync="dialogVisible"
                width="30%"
            >
                <span>开发中 此操作不会触发后端代码</span>
                <span slot="footer" class="dialog-footer">
                    <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                    <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
                </span>
            </el-dialog>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
export default {
    name: 'Message',
    components: {PageHeader},
    data() {
        return {
            dialogVisible: false,
            isShow: false,
            isHide: true
        }
    },
    methods: {
        back() {
            history.go(-1)
        },
        async changeIsNeedCaptcha(val1) {
            this.$confirm(`此操作将${!val1 ? '系统化' : '自定义'}验证, 是否继续？`, '来自shellwe的提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(async() => {
                this.isHide = !val1
                console.log('ishide1 ' + this.isHide)
                this.isShow = val1
                console.log('isshow1 ' + this.isShow + '||  val1 ' + val1)

                this.dialogVisible = true
            }).catch(() => {
                this.$message.error('取消操作')
                this.isShow = !val1
                this.isHide = val1

            })
        }
    }
}
</script>
<style>
.inLine {
    display: inline-block;
}
.hover {
    cursor: pointer;
}
</style>

