package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.ContactsNotFoundException;
import net.bambooslips.demo.exception.LegalRepresentativeNotFoundException;
import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.Contacts;
import net.bambooslips.demo.jpa.model.LegalRepresentative;
import net.bambooslips.demo.jpa.model.UnitEssential;
import net.bambooslips.demo.jpa.repository.ContactsRepository;
import net.bambooslips.demo.jpa.repository.LegalRepresentativeRepository;
import net.bambooslips.demo.jpa.service.ContactsService;
import net.bambooslips.demo.jpa.service.LegalRepresentativeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class ContactsServiceImpl implements ContactsService{

    private static final Logger LOG = LoggerFactory.getLogger(ContactsServiceImpl.class);
    @Resource
    private ContactsRepository contactsRepository;

    @Transactional
    @Override
    public Long create(Contacts contacts) {
        LOG.debug("Creating a new contacts with information: " + contacts);
        Contacts result = contactsRepository.save(contacts);
        if(result != null){
            return contacts.getContactsId();
        }
        return null;
    }

    /**
     * 更新作品状态
     * @param updated
     * @return
     * @throws ContactsNotFoundException
     */
    @Transactional(rollbackFor = ContactsNotFoundException.class)
    @Override
    public Contacts update(Contacts updated) throws ContactsNotFoundException {
        LOG.debug("Updating Contacts with information: " + updated);

        Contacts contacts = contactsRepository.findOne(updated.getContactsId());

        if (contacts == null) {
            LOG.debug("No post found with id: " + updated.getContactsId());
            throw new PostNotFoundException("Post "+updated.getContactsId()+" not found.");
        }
        contacts.update(updated);

        return contacts;
    }

    @Transactional(readOnly = true)
    @Override
    public Long findByEntireId(Long entireId) {
        LOG.debug("Finding UnitEssential by id: " + entireId);
        Contacts contacts =  contactsRepository.findByEntireId(entireId);
        if (contacts != null){
            Long ueId = contacts.getContactsId();
            return ueId;
        } else {
            return null;
        }
    }

    @Override
    public Contacts delete(Long id) {
        return null;
    }

}
