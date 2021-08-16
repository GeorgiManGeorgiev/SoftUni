package exam.model.dtos.jsons;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class ShopImportDto {
    @Expose
    private String name;

    public ShopImportDto() {
    }

    @NotNull
    public String getName() {
        return name;
    }

    public ShopImportDto setName(String name) {
        this.name = name;
        return this;
    }
}
