<template>
    <div>
        <page-header title="">
            <template #content>
                <div>
                    <div style="margin-bottom: 5px;">此页面为全局字典设置,在此页面控制本账号全局字典使用方式</div>
                    <span>是否开启数据字典 </span>
                    <el-switch
                        v-model="value1"
                        active-text="开启"
                        inactive-text="关闭"
                    />
                </div>
            </template>
        </page-header>
        <page-main>
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
    components: {PageMain},
    data() {
        return {
            value1: true,
            value2: true
        }
    }
}
</script>
