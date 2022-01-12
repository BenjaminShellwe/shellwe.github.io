<template>
    <div>
        <page-header title="安全设置">
            <template #content>
                <div class="inLine">
                    <p @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为账户的安全设置
                </div>
            </template>
        </page-header>
        <page-main>
            本页面还在设计中
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>
