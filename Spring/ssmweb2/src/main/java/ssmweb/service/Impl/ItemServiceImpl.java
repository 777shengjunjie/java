package ssmweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssmweb.domain.Item;
import ssmweb.mapper.ItemMapper;
import ssmweb.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item findById(int id) {
        return itemMapper.findById(id);
    }

}
