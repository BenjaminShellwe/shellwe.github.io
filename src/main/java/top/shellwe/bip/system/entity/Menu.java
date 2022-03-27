package top.shellwe.bip.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import top.shellwe.bip.common.entity.BaseEntity;
import top.shellwe.bip.common.validator.FieldRepeatValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>  系统管理-权限菜单表  </p>
 *
 */
@Data
@ApiModel(description = "系统管理-菜单表 ")
@TableName("t_sys_menu")
@FieldRepeatValidator(field = "resources", message = "菜单编码重复！")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@ApiModelProperty(value = "主键")
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	/**
	 * 类型 menu、button
	 */
	@ApiModelProperty(value = "类型 menu、button")
	@TableField("type")
	@NotBlank(message = "类型不能为空")
	private String type;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
