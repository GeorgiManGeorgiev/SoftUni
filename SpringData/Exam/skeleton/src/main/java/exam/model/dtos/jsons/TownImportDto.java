package exam.model.dtos.jsons;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class TownImportDto {
    @Expose
    private String name;

    public TownImportDto() {
    }

    @NotNull
    public String getName() {
        return name;
    }

    public TownImportDto setName(String name) {
        this.name = name;
        return this;
    }
}
