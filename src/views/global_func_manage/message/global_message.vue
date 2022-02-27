<template>
    <div>
        <page-header title="通知设置">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
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
                v-model="pageSwitch"
                active-text="系统化"
                inactive-text="自定义"
                @click.native="changeIsNeedCaptcha(pageSwitch)"
            />
            <div>
                <span v-show="pageVisibleUni" style="color: lightgreen;">注意,选择自定义将需要手动配置管理通知权重</span>
                <span v-show="pageVisibleBin" style="color: red;">注意,选择系统化将会由后台管理通知权重</span>
            </div>
            <el-dialog
                title="来自shellwe的警告"
                :visible.sync="dialogVisible"
                width="30%"
            >
                <span>未设置自定义逻辑,还请选择系统逻辑</span>
                <span slot="footer" class="dialog-footer">
                    <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                    <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
                </span>
            </el-dialog>
        </page-main>
        <page-main v-show="pageVisibleTer" title="通知详情">
            <el-row>
                <el-col :span="10">
                    <el-collapse v-model="pageCollapse">
                        <div>
                            <el-badge :value="1" :max="10" class="item">
                                <el-collapse-item title="系统通知" name="1">
                                </el-collapse-item>
                            </el-badge>
                        </div>
                        <div>
                            <el-badge :value="2" :max="10" class="item">
                                <el-collapse-item title="企业通知" name="2">
                                </el-collapse-item>
                            </el-badge>
                        </div>
                        <div>
                            <el-badge :value="3" :max="10" class="item">
                                <el-collapse-item title="广告通知" name="3">
                                </el-collapse-item>
                            </el-badge>
                        </div>
                        <div>
                            <el-badge :value="11" :max="10" class="item">
                                <el-collapse-item title="信息通知" name="4">
                                </el-collapse-item>
                            </el-badge>
                        </div>
                    </el-collapse>
                </el-col>
                <el-col :span="10">
                    <el-card style="margin-left: 20px; margin-right: 20px;" shadow="hover">
                        <span>点击左侧信息展示详 情</span>
                    </el-card>
                </el-col>
            </el-row>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Message',
    components: {PageMain, PageHeader},
    data() {
        return {
            dialogVisible: false,
            pageSwitch: true,
            pageVisibleUni: true,
            pageVisibleBin: false,
            pageVisibleTer: true,
            pageCollapse: ['']
        }
    },
    methods: {
        back() {
            history.go(-1)
        },
        async changeIsNeedCaptcha(val) {
            this.$confirm(`此操作将${!val ? '自定义' : '系统化'}验证, 是否继续？`, '来自shellwe的提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(async() => {
                this.pageVisibleUni = !val
                this.pageVisibleBin = val
                if (!this.pageSwitch) {
                    this.dialogVisible = true
                }
            }).catch(() => {
                this.$message.error('取消操作')
                this.pageSwitch = !val
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

