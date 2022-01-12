<template>
    <div>
        <page-header title="全局字典">
            <template #content>
                <div>
                    <div @click="back">返回上一页</div>
                    <div style="margin-bottom: 5px;">此页面为全局字典设置,在此页面控制本账号全局字典使用方式</div>
                    <span>是否开启数据字典 </span>
                    <el-switch
                        v-model="isShow"
                        active-text="开启"
                        inactive-text="关闭"
                        @click='changeShow'
                    />
                </div>
            </template>
        </page-header>
        <page-main v-show="isShow" id="collapsible">
            <span>是否允许系统读取 这个开关风格为换行
                <el-switch
                    v-model="value2"
                    style="display: block;"
                    active-color="#13ce66"
                    inactive-color="#ff4949"
                    active-text="开启"
                    inactive-text="关闭"
                /></span>
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
export default {
    name: 'GlobalDic',
    components: {PageMain},
    data() {
        return {
            isShow: true,
            value1: true,
            value2: true
        }
    },
    methods: {
        changeShow: function() {
            this.isShow = !this.isShow
        },
        back() {
            history.go(-1)
        }
    }
}
</script>
