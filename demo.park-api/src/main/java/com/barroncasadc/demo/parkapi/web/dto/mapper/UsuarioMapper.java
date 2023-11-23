package com.barroncasadc.demo.parkapi.web.dto.mapper;

import com.barroncasadc.demo.parkapi.entity.Usuario;
import com.barroncasadc.demo.parkapi.web.dto.UsuarioCreateDto;
import com.barroncasadc.demo.parkapi.web.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDto createDto) {
        return new ModelMapper().map(createDto, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario) {

        // removendo a inicial ROLE_ somante para admin/cliente
        String role = usuario.getRole().name().substring("ROLE_".length());

        // PropertyMap(fonte, destino)
        PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(usuario, UsuarioResponseDto.class);
    }
}
