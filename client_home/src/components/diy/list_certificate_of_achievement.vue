<template>
	<div class="diy_home diy_list diy_certificate_of_achievement" id="diy_certificate_of_achievement_list">
		<!-- 列表 -->
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods diy_list_box_wrap" v-for="(o, i) in list" :key="i"
				:to="'/certificate_of_achievement/details?certificate_of_achievement_id=' + o['certificate_of_achievement_id']">
				<!-- 图片 -->
				<div class="diy_list_img_box" v-if="imgList.length" >
					<div class="diy_row" v-for="(item,index) in imgList" :key="item+index" v-show="$check_field('get',item.name,'/certificate_of_achievement/details') && +item.is_img_list">
						<div class="diy_title diy_list_img_title">
							<span>{{item.title}}:</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(o[item.name])" style="width:100%;height:100%" />
						</div>
					</div>
				</div>
				<!-- 内容 -->
				<div class="diy_list_item_box">
					<div class="diy_list_item_content" v-for="(item,index) in showItemList" :key="item+index">
						<div class="diy_row" :class="{[item.name]:true}" v-if="$check_field('get',item.name,'/certificate_of_achievement/details') && +item.is_img_list">
							<div class="diy_title">
								<span>{{item.title}}:</span>
							</div>
							<div class="diy_field diy_text">
								<span v-if="item.type == 'UID'" v-text="get_user_name(o[item.name])"></span>
								<span v-else-if="item.type == '日期'" v-text="$toTime(o[item.name],'yyyy-MM-dd')"></span>
								<span v-else-if="item.type == '时间'" v-text="$toTime(o[item.name],'hh:mm:ss')"></span>
								<span v-else-if="item.type == '日长'" v-text="$toTime(o[item.name],'yyyy-MM-dd hh:mm:ss')"></span>
								<span v-else v-text="o[item.name]"></span>
							</div>
						</div>
					</div>
				</div>
			</router-link>
		</div>
		<!-- 表格 -->
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
						<th class="diy_title" v-if="$check_field('get','student_id')">
						学号
					</th>
							<th class="diy_title" v-if="$check_field('get','full_name')">
						姓名
					</th>
							<th class="diy_title" v-if="$check_field('get','upload_topic')">
						上传主题
					</th>
							<th class="diy_title" v-if="$check_field('get','upload_type')">
						上传类型
					</th>
							<th class="diy_title" v-if="$check_field('get','get_time')">
						获取时间
					</th>
							<th class="diy_title" v-if="$check_field('get','upload_pictures')">
						上传图片
					</th>
							<th class="diy_title" v-if="$check_field('get','remarks')">
						备注
					</th>
					</tr>
				<tr class="diy_row" v-for="(o,i) in list" :key="o+i">
						<td class="diy_field diy_uid" v-if="$check_field('get','student_id')">
						<span>
							{{ get_user_name(o['student_id']) }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','full_name')">
						<span>
							{{ o["full_name"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','upload_topic')">
						<span>
							{{ o["upload_topic"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','upload_type')">
						<span>
							{{ o["upload_type"] }}
						</span>
					</td>
							<td class="diy_field diy_date" v-if="$check_field('get','get_time')">
						<span>
							{{ $toTime(o["get_time"] ,"yyyy-MM-dd") }}
						</span>
					</td>
							<td class="diy_field" v-if="$check_field('get','upload_pictures')">
						<img class="diy_img" :src="o['upload_pictures']" />
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','remarks')">
						<span>
							{{ o["remarks"] }}
						</span>
					</td>
					</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				},
			},
			show: {
				type: Boolean,
				default: function(){
					return true;
				}
			}
		},
		data() {
			return {
						imgList: [
						{
							title: "上传图片",
							name: "upload_pictures",
							type: "图片",
							is_img_list: "0"
						},
						],
						itemList: [
								{
									title: "学号",
									name: "student_id",
									type: "UID",
									is_img_list: "0"
								},
								{
									title: "姓名",
									name: "full_name",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "上传主题",
									name: "upload_topic",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "上传类型",
									name: "upload_type",
									type: "下拉",
									is_img_list: "0"
								},
								{
									title: "获取时间",
									name: "get_time",
									type: "日期",
									is_img_list: "0"
								},
						],
						richList: [
								{
									title: "备注",
									name: "remarks",
									type: "多文本"
								},
						],
					// 用户列表
				list_user_student_id: [],
										};
		},
		methods: {
				/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_student() {
				var json = await this.$get("~/api/user/get_list?user_group=普通用户");
				if(json.result && json.result.list){
					this.list_user_student_id = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_name(id){
				var obj = this.list_user_student_id.getObj({"user_id":id});
				var ret = "";
				if(obj){
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
									},
		created() {
				this.get_list_user_student();
									},
		computed:{
			showItemList(){
				let arr = [];
				let _type = ["视频","音频","文件"];
				this.itemList.forEach(item => {
					if(_type.indexOf(item.type) === -1 && !!+item.is_img_list){
						arr.push(item)
					}
				})
				return arr.slice(0,4);
			}
		}
	};
</script>

<style scoped>
	.media {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		flex-basis: 75%;
		min-height: 10rem;
	}

	.goods {
		display: flex;
		width: calc(25% - 1rem);
		margin: 0.5rem;
		padding: 0.5rem;
		flex-direction: column;
		justify-content: space-between;
		background-color: white;
		border-radius: 0.5rem;
	}

	.goods:hover {
		border: 0.2rem solid #909399;
		box-shadow: 0 0.1rem 0.3rem rgba(0, 0, 0, 0.15);
	}

	.goods:hover img {
		filter: blur(1px);
	}

	.price {
		font-size: 1rem;
		margin-right: 3px;
	}

	.price_ago {
		text-decoration: line-through;
		font-size: 0.5rem;
		color: #999;

	}

	.title {
		word-break: break-all;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		padding: .25rem;
	}

	.icon_cart {
		color: #FF5722;
		float: right;
	}

	@media (max-width: 992px) {

		.goods {
			width: calc(33% - 1rem);
			;
		}

	}

	@media (max-width: 768px) {

		.goods {
			width: calc(50% - 1rem);
			;
		}

	}
</style>

