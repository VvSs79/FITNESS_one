package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.converter.mail.MailConverterDtoToEntity;
import Mk.JD2_95_22.fitness.converter.mail.MailConverterEntityTolDTO;
import Mk.JD2_95_22.fitness.converter.product.*;
import Mk.JD2_95_22.fitness.converter.user.*;
import Mk.JD2_95_22.fitness.orm.repository.IMailRepository;
import Mk.JD2_95_22.fitness.orm.repository.IProductRepositpry;
import Mk.JD2_95_22.fitness.orm.repository.IRecepteRepository;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.mail.MailService;
import Mk.JD2_95_22.fitness.servise.product.ProductService;
import Mk.JD2_95_22.fitness.servise.product.RecepteService;
import Mk.JD2_95_22.fitness.servise.user.UserService;
import Mk.JD2_95_22.fitness.servise.api.IMailService;
import Mk.JD2_95_22.fitness.servise.api.IProductService;
import Mk.JD2_95_22.fitness.servise.api.IRecepteService;
import Mk.JD2_95_22.fitness.servise.api.IUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class ConfigServise {
    public IUserService userService(IUserRepository repository,
                                    UserConverterDtoToEntity userConverterDtoToEntity,
                                    UserConverterEntityToDTO userConverterEntityToDTO,
                                    UserConverterEntityToModel userConverterEntityToModel,
                                    UserConverterEntityToPage userConverterEntityToPage
                                    ) {
      return new UserService(repository,
              userConverterDtoToEntity,
              userConverterEntityToDTO,
              userConverterEntityToModel,
              userConverterEntityToPage);
  }
  public IProductService productServise(IProductRepositpry repository,
                                        ProductConverterDtoToEntity productConverterDtoToEntity,
                                        ProductConvertertEntityToDTO productConvertertEntityToDTO,
                                        ProductConverterEntityToModel productConverterPEntityToModel,
                                        ProductConverterModelToEntity productConverterModelToEntity,
                                        ProductConverterEntityToPage productConverterEntityToPage){
        return new ProductService(repository,
                productConverterDtoToEntity,
                productConvertertEntityToDTO,
                productConverterPEntityToModel,
                productConverterModelToEntity,
                productConverterEntityToPage);
  }

  public IRecepteService recepteServise(IRecepteRepository repository,
                                        IProductService productService,
                                        ProductConverterModelToEntity productConverterModelToEntity,
                                        ProductConverterEntityToModel productConverterEntityToModel){
        return new RecepteService();


  }
  public IMailService mailService(IMailRepository repository,
                                  MailConverterDtoToEntity mailConverterDtoToEntity,
                                  MailConverterEntityTolDTO mailConverterEntityTolDTO,
                                  JavaMailSender mailSender){
        return new MailService(repository,
                mailConverterDtoToEntity,
                mailConverterEntityTolDTO,
                mailSender);
  }

}
