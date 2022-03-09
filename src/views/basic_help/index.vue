<template>
    <div>
        <page-header title="帮助说明">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
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
            <p>fip-shellwe-admin是基于多个后台管理系统糅合更改进行从新开发的框架整体主题风格采用 ElementUI,若不熟悉可先去了解。</p>
            <el-collapse v-model="activeNames" @change="handleChange">
                <el-collapse-item title="1.1环境搭建" name="1">
                    <div>前端项目(指代fip-shellwe-admin下同),采用vue.js编写所以需要搭建对应的环境。</div>
                    <div><a :href="'https://www.cnblogs.com/lgx5/p/10732016.html'">安装教程 - 每天进步多一点 - 博客园</a> 此链接包含node.js安装 vue vue-cli等必须的开发环境安装说明,在此就不再过多赘述。</div>
                </el-collapse-item>
                <el-collapse-item title="1.2运行此项目" name="2">
                    <el-collapse-item title="1.2.1 命令提示符形式(推荐)" name="2-sub1">
                        <div>
                            你应该已经拥有了本项目压缩包，由于内部文件仍在修改，所以不提供哈希值验证，直接解压进入目录即可<br>
                            <img :src="img121"><br>
                            <img :src="img1211"><br>
                            进入此页面，在vue所需环境安装完成后输入<br>
                            <p>
                                # 安装依赖<br>
                                npm install<br>
                                # 运行 其中变量为dev(开发环境) 建议使用 serve(生产环境) 或init<br>
                                npm run serve<br>
                            </p>
                            <img :src="img1212"><br>
                            弹出此窗口会触发默认浏览器自动打开，建议使用谷歌浏览器，若没有触发，可自行到浏览器输入
                            localhost:8089 此处可点击触发<br>
                        </div>
                    </el-collapse-item>
                    <el-collapse-item title="1.2.2 IDEA形式(开发)" name="2-sub2">
                        <div>
                            <img :src="img1221"><br>
                            使用IDEA打开存放项目的路径<br>
                            打开后如图<br>
                            <img :src="img1222"><br>
                            <img :src="img1223"><br>
                            <img :src="img1224"><br>
                            <img :src="img1225"><br>
                            选择npm<br>
                            <img :src="img1226"><br>
                            <img :src="img1227"><br>
                            点击运行<br>
                            <img :src="img1228"><br>
                            Done 说明运行成功会触发默认浏览器访问,或者点击上方连接<br>
                            <img :src="img1229">此为中止按钮，功能同命令提示符中输入 Ctrl+C效果一致<br>
                        </div>
                    </el-collapse-item>
                </el-collapse-item>
                <el-collapse-item title="开发中" name="3">
                    <div>简化中</div>
                    <div>决策中</div>
                </el-collapse-item>
                <el-collapse-item title="控制中" name="4">
                    <div>决策中</div>
                </el-collapse-item>
            </el-collapse>

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
            img121: require('../../../public/image/121.png'),
            img1211: require('../../../public/image/1211.png'),
            img1212: require('../../../public/image/1212.png'),
            img1221: require('../../../public/image/1221.png'),
            img1222: require('../../../public/image/1222.png'),
            img1223: require('../../../public/image/1223.png'),
            img1224: require('../../../public/image/1224.png'),
            img1225: require('../../../public/image/1225.png'),
            img1226: require('../../../public/image/1226.png'),
            img1227: require('../../../public/image/1227.png'),
            img1228: require('../../../public/image/1228.png'),
            img1229: require('../../../public/image/1229.png'),
            centerDialogVisible: false,
            activeNames: ['1']
        }
    },
    mounted() {
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
        },
        handleChange(val) {
            console.log(val)
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
